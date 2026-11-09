# Sisora

Sisora is a refined maternity and celebration boutique web app—soft peplums, luminous jewelry, and bump-friendly co-ords with a calmer, more aesthetic shopping experience.

## Roles

### Customer
1. Sign in / create account  
2. Add products to bag  
3. Place order with delivery details  
4. Pay via **UPI QR** (scan or open UPI app)  
5. Tap **I’ve paid** (optional txn note)  
6. Track orders in **Orders**

### Owner
1. First account created becomes owner (or use email matching `OWNER_EMAIL`, default `owner@sisora.shop`)  
2. Open **Owner** in the header  
3. **Products** — add/edit/delete name, price, image URL, category, sold-out  
4. **UPI QR** — default is `vijayalakshmik1012000@okicici` (Vijayalakshmi Kumar); change anytime in Owner → UPI QR  
5. **Orders** — after customer pays, confirm in your UPI app, then **Mark payment received**

## Features

- Dynamic product catalog (owner-managed)
- Custom email/password login (no Cursor auth)
- Online UPI QR checkout
- Orders saved to Postgres when published; in-memory fallback locally

## Run locally

```bash
cd sisora
npm install
npm run dev
```

Open [http://localhost:3847](http://localhost:3847).

On this Windows setup, the app runs with **Webpack** (Turbopack native bindings are blocked by Application Control). Tailwind is compiled via PostCSS.

Optional: set `OWNER_EMAIL=you@example.com` so that email is always treated as owner on signup.

## Scripts

- `npm run dev` — start the development server
- `npm run build` — production build
- `npm run start` — serve the production build
- `npm run lint` — run ESLint
