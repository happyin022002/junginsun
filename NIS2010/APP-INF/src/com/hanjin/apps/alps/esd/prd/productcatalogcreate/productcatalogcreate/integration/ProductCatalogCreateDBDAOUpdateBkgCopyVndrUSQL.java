/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOUpdateBkgCopyVndrUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.09.17 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOUpdateBkgCopyVndrUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UpdateBkgCopyVndr
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOUpdateBkgCopyVndrUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("copy_cnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hd_pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration ").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOUpdateBkgCopyVndrUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("update PRD_PROD_CTL_ROUT_DTL dtl" ).append("\n"); 
		query.append("set (N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ) =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select n1st,n2nd,n3rd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select PCTL_NO,PCTL_SEQ,ORG_NOD_CD,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,n1st,n2nd,n3rd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select PCTL_NO,PCTL_SEQ,ORG_NOD_CD,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("( SELECT TO_CHAR(N1ST_VNDR_SEQ)  FROM MDM_YARD  WHERE YD_CD = ORG_NOD_CD) n1st," ).append("\n"); 
		query.append("( SELECT TO_CHAR(N2ND_VNDR_SEQ)  FROM MDM_YARD  WHERE YD_CD = ORG_NOD_CD) n2nd," ).append("\n"); 
		query.append("( SELECT TO_CHAR(N3RD_VNDR_SEQ)  FROM MDM_YARD  WHERE YD_CD = ORG_NOD_CD) n3rd" ).append("\n"); 
		query.append("from PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("where PCTL_NO = @[hd_pctl_no]||LPAD(@[copy_cnt],4,'0')" ).append("\n"); 
		query.append("and NOD_LNK_DIV_CD ='N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where N1ST_VNDR_SEQ <> n1st" ).append("\n"); 
		query.append("or  N2ND_VNDR_SEQ <> n2nd" ).append("\n"); 
		query.append("or  N3RD_VNDR_SEQ <> n3rd" ).append("\n"); 
		query.append(") bad" ).append("\n"); 
		query.append("where dtl.PCTL_SEQ = bad.PCTL_SEQ" ).append("\n"); 
		query.append("and dtl.PCTL_NO = bad.PCTL_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where dtl.PCTL_NO = @[hd_pctl_no]||LPAD(@[copy_cnt],4,'0')" ).append("\n"); 
		query.append("and exists" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select 'X'" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select PCTL_NO,PCTL_SEQ,ORG_NOD_CD,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ,n1st,n2nd,n3rd" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select PCTL_NO,PCTL_SEQ,ORG_NOD_CD,N1ST_VNDR_SEQ,N2ND_VNDR_SEQ,N3RD_VNDR_SEQ," ).append("\n"); 
		query.append("( SELECT TO_CHAR(N1ST_VNDR_SEQ)  FROM MDM_YARD  WHERE YD_CD = ORG_NOD_CD) n1st," ).append("\n"); 
		query.append("( SELECT TO_CHAR(N2ND_VNDR_SEQ)  FROM MDM_YARD  WHERE YD_CD = ORG_NOD_CD) n2nd," ).append("\n"); 
		query.append("( SELECT TO_CHAR(N3RD_VNDR_SEQ)  FROM MDM_YARD  WHERE YD_CD = ORG_NOD_CD) n3rd" ).append("\n"); 
		query.append("from PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("where PCTL_NO = @[hd_pctl_no]||LPAD(@[copy_cnt],4,'0')" ).append("\n"); 
		query.append("and NOD_LNK_DIV_CD ='N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("where N1ST_VNDR_SEQ <> n1st" ).append("\n"); 
		query.append("or  N2ND_VNDR_SEQ <> n2nd" ).append("\n"); 
		query.append("or  N3RD_VNDR_SEQ <> n3rd" ).append("\n"); 
		query.append(") bad" ).append("\n"); 
		query.append("where dtl.PCTL_SEQ = bad.PCTL_SEQ" ).append("\n"); 
		query.append("and dtl.PCTL_NO = bad.PCTL_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}