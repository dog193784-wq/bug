# GitHub Pages Takeover Triage Lab

A static, read-only helper for triaging possible dangling GitHub Pages DNS records during authorized security assessments.

## Deploy with GitHub Pages

1. Open this repository on GitHub.
2. Go to **Settings → Pages**.
3. Under **Build and deployment**, select **Deploy from a branch**.
4. Choose branch **main** and folder **/(root)**, then click **Save**.
5. Wait for the deployment status/link to appear on the Pages settings screen. Open the URL GitHub provides. The expected project-site URL format is `https://dog193784-wq.github.io/bug/`, but use the actual URL shown by GitHub.
6. If the Pages section offers a visibility or plan warning, follow GitHub's instructions for this repository's visibility and account plan.

## Use

Enter a hostname you own or are explicitly authorized to assess, then select **Check CNAME**. The page queries Cloudflare's public DNS-over-HTTPS endpoint for a CNAME record. You can add HTTP observations and notes, then export the evidence as JSON.

## Important limitations

- A `*.github.io` CNAME is only an indicator; it does not prove that a custom domain is unclaimed or claimable.
- An HTTP 404, DNS failure, or missing CNAME is not proof of a vulnerability.
- The browser page does not automatically fingerprint HTTP responses; record observations from approved tooling separately.
- The app does not attempt to claim a repository, attach a custom domain, or alter DNS.
- Only test in-scope assets. Use a domain you own for any claimability experiment and follow GitHub's current policies.

References:
- https://docs.github.com/en/pages/configuring-a-custom-domain-for-your-github-pages-site
- https://docs.github.com/en/pages/getting-started-with-github-pages/about-github-pages
