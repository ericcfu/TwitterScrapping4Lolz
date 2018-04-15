import twitter

api = twitter.Api(consumer_key='87FR7DTpl5x9XDIBA6SC0vCRs',
    consumer_secret='pU3k1u50EaMrIdYh5grCdz3CIJr0knAdpyQ4BOP2hzapbYcVNI',
    access_token_key='543791723-aXCZPz63s8oBPPLuJhb6cLhzYXQHzUQ3EaucxL7p',
    access_token_secret='FsWMZi1hGS4tlGkaCMhrHjGoYhQLdwEWCvBLg7WeGjBmE')

print(api.VerifyCredentials())