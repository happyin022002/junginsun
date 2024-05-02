/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOManageBlReIssueCollectCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.01.20 이진서
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Jin Seo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOManageBlReIssueCollectCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ManageBlReIssueCollect
	  * </pre>
	  */
	public BLIssuanceDBDAOManageBlReIssueCollectCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("iss_rdem_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOManageBlReIssueCollectCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_DOC_ISS_RDEM (" ).append("\n"); 
		query.append("BKG_NO, HIS_SEQ, EVNT_OFC_CD, OBL_RDEM_CFM_FLG," ).append("\n"); 
		query.append("ISS_RDEM_KNT, EVNT_USR_ID, EVNT_DT," ).append("\n"); 
		query.append("CRE_USR_ID, CRE_DT, UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[bkg_no],(SELECT  NVL(MAX(HIS_SEQ),0)+1 AS SEQ FROM BKG_DOC_ISS_RDEM WHERE BKG_NO = @[bkg_no] ), @[evnt_ofc_cd], 'N'," ).append("\n"); 
		query.append("@[iss_rdem_knt], @[evnt_usr_id], TO_DATE(replace(substr(@[evnt_dt],1,10),'-',''),'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("@[cre_usr_id], sysdate, @[upd_usr_id]," ).append("\n"); 
		query.append("sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}