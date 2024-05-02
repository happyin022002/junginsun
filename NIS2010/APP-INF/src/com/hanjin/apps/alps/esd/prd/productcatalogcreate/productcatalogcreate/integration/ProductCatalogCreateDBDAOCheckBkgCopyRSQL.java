/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOCheckBkgCopyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.15
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.15 정선용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOCheckBkgCopyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CheckBkgCopy
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOCheckBkgCopyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOCheckBkgCopyRSQL").append("\n"); 
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
		query.append("select" ).append("\n"); 
		query.append("pctl_no ," ).append("\n"); 
		query.append("decode(O_ROUT_ORG_NOD_CD,'','N','Y' ) pc_exist," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when O_ROUT_ORG_NOD_CD= O_ROUT_DEST_NOD_CD and O_ROUT_SEQ =0 then 'Y'" ).append("\n"); 
		query.append("else nvl(( select 'Y' from prd_inlnd_rout_mst i" ).append("\n"); 
		query.append("where i.ROUT_ORG_NOD_CD = O_ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("and i.ROUT_DEST_NOD_CD = O_ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("and NVL(i.INLND_ROUT_BKG_FLG,'N')  = 'Y'" ).append("\n"); 
		query.append("and i.PCTL_IO_BND_CD IN ('O','B')" ).append("\n"); 
		query.append("and i.rout_seq = O_ROUT_SEQ and nvl(i.DELT_FLG,'N') = 'N') , 'X')" ).append("\n"); 
		query.append("end OUT_B," ).append("\n"); 
		query.append("case" ).append("\n"); 
		query.append("when I_ROUT_ORG_NOD_CD= I_ROUT_DEST_NOD_CD and I_ROUT_SEQ =0 then 'Y'" ).append("\n"); 
		query.append("else nvl(( select 'Y' from prd_inlnd_rout_mst i" ).append("\n"); 
		query.append("where i.ROUT_ORG_NOD_CD = I_ROUT_ORG_NOD_CD" ).append("\n"); 
		query.append("and i.ROUT_DEST_NOD_CD = I_ROUT_DEST_NOD_CD" ).append("\n"); 
		query.append("and NVL(i.INLND_ROUT_BKG_FLG,'N')  = 'Y'" ).append("\n"); 
		query.append("and i.PCTL_IO_BND_CD IN ('I','B')" ).append("\n"); 
		query.append("and i.rout_seq = I_ROUT_SEQ and nvl(i.DELT_FLG,'N') = 'N') , 'X')" ).append("\n"); 
		query.append("end IN_B" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("min(decode(r,1, pctl_no,pctl_no)) pctl_no ," ).append("\n"); 
		query.append("min(decode(r,1, ROUT_ORG_NOD_CD)) O_ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("min(decode(r,1, ROUT_DEST_NOD_CD)) O_ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("min(decode(r,1, ROUT_SEQ)) O_ROUT_SEQ," ).append("\n"); 
		query.append("min(decode(r,2, ROUT_ORG_NOD_CD)) I_ROUT_ORG_NOD_CD," ).append("\n"); 
		query.append("min(decode(r,2, ROUT_DEST_NOD_CD)) I_ROUT_DEST_NOD_CD," ).append("\n"); 
		query.append("min(decode(r,2, ROUT_SEQ)) I_ROUT_SEQ" ).append("\n"); 
		query.append("from" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select distinct m.pctl_no ," ).append("\n"); 
		query.append("ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,PCTL_IO_BND_CD ," ).append("\n"); 
		query.append("ROW_NUMBER() OVER(  ORDER BY PCTL_IO_BND_CD desc) r" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_mst m, PRD_PROD_CTL_rout_dtl d" ).append("\n"); 
		query.append("where m.pctl_no = (select pctl_no from bkg_booking where bkg_no =@[bkg_no])" ).append("\n"); 
		query.append("and m.pctl_no = d.pctl_no" ).append("\n"); 
		query.append("and d.PCTL_IO_BND_CD in ('O','I')" ).append("\n"); 
		query.append("group by m.pctl_no,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ,PCTL_IO_BND_CD" ).append("\n"); 
		query.append("order by d.PCTL_IO_BND_CD desc" ).append("\n"); 
		query.append(") p" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}