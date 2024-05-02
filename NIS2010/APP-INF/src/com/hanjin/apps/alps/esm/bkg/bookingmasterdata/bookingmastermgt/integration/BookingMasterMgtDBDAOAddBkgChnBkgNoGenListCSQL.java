/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BookingMasterMgtDBDAOAddBkgChnBkgNoGenListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.01.11 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOAddBkgChnBkgNoGenListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선 생성된 북중국 BKG NO 목록 등록
	  * </pre>
	  */
	public BookingMasterMgtDBDAOAddBkgChnBkgNoGenListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_cre_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chn_agn_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOAddBkgChnBkgNoGenListCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CHN_BKG_NO_GEN (" ).append("\n"); 
		query.append("BKG_NO," ).append("\n"); 
		query.append("CHN_AGN_CD," ).append("\n"); 
		query.append("BKG_NO_USE_FLG," ).append("\n"); 
		query.append("BKG_CRE_DT," ).append("\n"); 
		query.append("CRE_OFC_CD," ).append("\n"); 
		query.append("DOC_USR_ID," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT)" ).append("\n"); 
		query.append("VALUES (" ).append("\n"); 
		query.append("@[bkg_no]," ).append("\n"); 
		query.append("@[chn_agn_cd]," ).append("\n"); 
		query.append("'N'," ).append("\n"); 
		query.append("TO_DATE(@[bkg_cre_dt], 'YYYY-MM-DD HH24:MI:SS'), --GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(:creOfcCd)" ).append("\n"); 
		query.append("@[cre_ofc_cd]," ).append("\n"); 
		query.append("NULL," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[cre_ofc_cd]))," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[cre_ofc_cd]))" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}