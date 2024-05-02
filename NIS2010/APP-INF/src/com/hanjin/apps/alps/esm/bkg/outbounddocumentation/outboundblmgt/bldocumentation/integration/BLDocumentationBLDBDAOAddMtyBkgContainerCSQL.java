/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOAddMtyBkgContainerCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.19
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.19 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOAddMtyBkgContainerCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Empty Booking Container 저장
	  * </pre>
	  */
	public BLDocumentationBLDBDAOAddMtyBkgContainerCSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mcntr_bdl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdl_btm_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOAddMtyBkgContainerCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CONTAINER(" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("RCV_TERM_CD," ).append("\n"); 
		query.append("DE_TERM_CD," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("CNMV_CYC_NO," ).append("\n"); 
		query.append("CNMV_STS_CD," ).append("\n"); 
		query.append("PCK_QTY," ).append("\n"); 
		query.append("CNTR_PRT_FLG," ).append("\n"); 
		query.append("CSTMS_PRN_FLG," ).append("\n"); 
		query.append("DCGO_FLG," ).append("\n"); 
		query.append("RC_FLG," ).append("\n"); 
		query.append("BB_CGO_FLG," ).append("\n"); 
		query.append("AWK_CGO_FLG," ).append("\n"); 
		query.append("RD_CGO_FLG," ).append("\n"); 
		query.append("HNGR_FLG," ).append("\n"); 
		query.append("SOC_FLG," ).append("\n"); 
		query.append("CNMV_FLG," ).append("\n"); 
		query.append("CNTR_DELT_FLG," ).append("\n"); 
		query.append("MCNTR_BDL_NO," ).append("\n"); 
		query.append("BDL_BTM_FLG," ).append("\n"); 
		query.append("CGO_RCV_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select" ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("@[cntr_no]," ).append("\n"); 
		query.append("cntr_tpsz_cd," ).append("\n"); 
		query.append("'Y'," ).append("\n"); 
		query.append("'Y'," ).append("\n"); 
		query.append("CNMV_YR," ).append("\n"); 
		query.append("CNMV_ID_NO," ).append("\n"); 
		query.append("decode(CNMV_STS_CD, 'VL', nvl(CNMV_CYC_NO, 9999), 9999)," ).append("\n"); 
		query.append("CNMV_STS_CD," ).append("\n"); 
		query.append("0," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("@[mcntr_bdl_no]," ).append("\n"); 
		query.append("nvl(@[bdl_btm_flg], 'N')," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC((SELECT OFC_CD FROM COM_USER WHERE USR_ID = @[cre_usr_id])))," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("from mst_container" ).append("\n"); 
		query.append("where cntr_no = @[cntr_no]" ).append("\n"); 

	}
}