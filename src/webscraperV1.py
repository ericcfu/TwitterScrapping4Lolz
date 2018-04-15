import twitter
import sys

api = twitter.Api(consumer_key='87FR7DTpl5x9XDIBA6SC0vCRs',
    consumer_secret='pU3k1u50EaMrIdYh5grCdz3CIJr0knAdpyQ4BOP2hzapbYcVNI',
    access_token_key='543791723-aXCZPz63s8oBPPLuJhb6cLhzYXQHzUQ3EaucxL7p',
    access_token_secret='FsWMZi1hGS4tlGkaCMhrHjGoYhQLdwEWCvBLg7WeGjBmE')

# print(api.VerifyCredentials())
# help(api.GetUserTimeline)
twitter_handle = 'jerrybearysong'
num_tweets = 10

try:
    twitter_handle = sys.argv[1]
    num_tweets = sys.argv[2]
except:
    None
    
status_list = api.GetUserTimeline(screen_name=twitter_handle, count=num_tweets)
tweets = [i.AsDict() for i in status_list]
print_errors = 0

for tweet in tweets:
    try:
        print(tweet['text'])
    except:
        print_errors += 1
