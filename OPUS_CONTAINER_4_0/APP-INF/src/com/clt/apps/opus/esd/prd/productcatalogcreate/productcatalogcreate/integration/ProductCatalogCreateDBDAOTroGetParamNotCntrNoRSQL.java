/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ProductCatalogCreateDBDAOTroGetParamNotCntrNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.15
*@LastModifier : 정선용
*@LastVersion : 1.0
* 2009.11.15 정선용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author sun yong Jung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ProductCatalogCreateDBDAOTroGetParamNotCntrNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TroGetParamNotCntrNo
	  * </pre>
	  */
	public ProductCatalogCreateDBDAOTroGetParamNotCntrNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pc_mode",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.integration").append("\n"); 
		query.append("FileName : ProductCatalogCreateDBDAOTroGetParamNotCntrNoRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("T.PCTL_NO PCTL_NO, T.CNTR_TPSZ_CD, (T.PCTL_QTY - NVL(O.PCTL_QTY,0)) QTY," ).append("\n"); 
		query.append("BKG_RCV_TERM_CD,BKG_DE_TERM_CD,MTY_PKUP_YD_CD MT_PU,MTY_RTN_YD_CD MT_RTN," ).append("\n"); 
		query.append("'' INCL_SHTL_SO_FLG, ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MAX(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =T.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='O') CCT ," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MIN(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =T.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='T') POL_T," ).append("\n"); 
		query.append("(SELECT TO_CHAR(MIN(ARR_ST_DT),'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_ROUT_DTL" ).append("\n"); 
		query.append("WHERE PCTL_NO =T.PCTL_NO" ).append("\n"); 
		query.append("AND PCTL_IO_BND_CD ='I') POD_T" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("PCTL_NO, CNTR_TPSZ_CD, PCTL_QTY" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_QTY" ).append("\n"); 
		query.append("WHERE PCTL_NO =" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(") T," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("CNTR_TPSZ_CD, SUM(PCTL_QTY) PCTL_QTY" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_QTY" ).append("\n"); 
		query.append("WHERE PCTL_NO IN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT PCTL_NO" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND PCTL_NO =(SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO =@[bkg_no])" ).append("\n"); 
		query.append("AND SUBSTR(PCTL_NO,1,1) = @[pc_mode]   -- TRO_I, TRO_O 에 따라 I,O" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("GROUP BY CNTR_TPSZ_CD" ).append("\n"); 
		query.append(") O ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT BKG_RCV_TERM_CD,BKG_DE_TERM_CD,MTY_PKUP_YD_CD,MTY_RTN_YD_CD,ROUT_ORG_NOD_CD,ROUT_DEST_NOD_CD,ROUT_SEQ" ).append("\n"); 
		query.append("FROM PRD_PROD_CTL_MST M,  PRD_PROD_CTL_ROUT_DTL D" ).append("\n"); 
		query.append("WHERE M.PCTL_NO =(SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO =@[bkg_no])" ).append("\n"); 
		query.append("AND M.PCTL_NO = D.PCTL_NO" ).append("\n"); 
		query.append("AND D.PCTL_IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND ROWNUM =1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T.CNTR_TPSZ_CD = O.CNTR_TPSZ_CD(+)" ).append("\n"); 

	}
}