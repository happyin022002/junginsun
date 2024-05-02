/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingMasterMgtDBDAOBkgVvdBdrLogVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.12.08 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOBkgVvdBdrLogVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * search
	  * </pre>
	  */
	public BookingMasterMgtDBDAOBkgVvdBdrLogVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOBkgVvdBdrLogVORSQL").append("\n"); 
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
		query.append("TRNK_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_MNL_BDR_DT" ).append("\n"); 
		query.append(",	TRNK_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	FDR_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_ESTM_BDR_DT" ).append("\n"); 
		query.append(",	FDR_AUTO_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_AUTO_BDR_DT" ).append("\n"); 
		query.append(",	FDR_MNL_BDR_FLG" ).append("\n"); 
		query.append(",	FDR_MNL_BDR_DT" ).append("\n"); 
		query.append(",	FDR_BDR_CRE_USR_ID" ).append("\n"); 
		query.append(",	FDR_BDR_UPD_DT" ).append("\n"); 
		query.append(",	BDR_VSL_CHK_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	SLAN_TP_CD" ).append("\n"); 
		query.append(",	TRNK_BDR_FLG" ).append("\n"); 
		query.append(",	TRNK_ESTM_BDR_DT" ).append("\n"); 
		query.append(",	'' VSL_SLAN_CD" ).append("\n"); 
		query.append(",	'' SKD_STS_CD" ).append("\n"); 
		query.append(",	'' CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	'' SKD_CNG_STS_CD" ).append("\n"); 
		query.append(",	'' TURN_PORT_IND_CD" ).append("\n"); 
		query.append(",	'' VPS_ETA_DT" ).append("\n"); 
		query.append(",	'' VPS_ETB_DT" ).append("\n"); 
		query.append(",	'' VPS_ETD_DT" ).append("\n"); 
		query.append(",	'' VPS_PORT_CD" ).append("\n"); 
		query.append(",	'' PORT_SKD_STS_CD" ).append("\n"); 
		query.append(",	'' O_RESULT" ).append("\n"); 
		query.append(",	'' O_ERR_MSG" ).append("\n"); 
		query.append("FROM BKG_VVD_BDR_LOG" ).append("\n"); 

	}
}