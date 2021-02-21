import { Product } from "./Product";

export type ProductResponse = {
  content: Product[];
  totalPages: number;
}