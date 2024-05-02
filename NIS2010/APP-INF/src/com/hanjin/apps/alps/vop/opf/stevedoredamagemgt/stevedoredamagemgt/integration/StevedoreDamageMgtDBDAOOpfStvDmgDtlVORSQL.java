/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOOpfStvDmgDtlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.31
*@LastModifier : 
*@LastVersion : 1.0
* 2011.03.31 
* 1.0 Creation
* 2011.04.01 공창식 [CHM-201109535-01] SDMS Damage Creation 변경 요청사항
=========================================================*/
package com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOOpfStvDmgDtlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStvDmgDtlVO Select Query
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOOpfStvDmgDtlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stv_dmg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOOpfStvDmgDtlVORSQL").append("\n"); 
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
		query.append("STV_DMG_NO" ).append("\n"); 
		query.append(",	STV_DMG_PRT_CATE_CD" ).append("\n"); 
		query.append(",	STV_DMG_PRT_CD" ).append("\n"); 
		query.append(",	STV_DMG_TP_CD" ).append("\n"); 
		query.append(",	STV_DMG_LOC_DESC" ).append("\n"); 
		query.append(",	STV_DMG_RPT_ATCH_FLG" ).append("\n"); 
		query.append(",	STV_DMG_PICT_ATCH_FLG" ).append("\n"); 
		query.append(",	STV_DMG_DOC_ATCH_FLG" ).append("\n"); 
		query.append(",	CNTR_DMG_FLG" ).append("\n"); 
		query.append(",	CGO_DMG_FLG" ).append("\n"); 
		query.append(",	CNTR_NO" ).append("\n"); 
		query.append(",	TO_CHAR(FM_TM_LSS_DT, 'YYYY-MM-DD HH24:MI') AS FM_TM_LSS_DT" ).append("\n"); 
		query.append(",	TO_CHAR(TO_TM_LSS_DT, 'YYYY-MM-DD HH24:MI') AS TO_TM_LSS_DT" ).append("\n"); 
		query.append(",	STV_DMG_RMK" ).append("\n"); 
		query.append(",	STV_DMG_REQ_CATE_CD" ).append("\n"); 
		query.append(",	REQ_VSL_CD" ).append("\n"); 
		query.append(",	REQ_SKD_VOY_NO" ).append("\n"); 
		query.append(",	REQ_SKD_DIR_CD" ).append("\n"); 
		query.append(",	REQ_PORT_CD" ).append("\n"); 
		query.append(",	TO_CHAR(REQ_ETA_DT, 'YYYY-MM-DD') AS REQ_ETA_DT" ).append("\n"); 
		query.append(",	STV_DMG_QTTN_CD" ).append("\n"); 
		query.append(",	STV_DMG_QTTN_RSN_DESC" ).append("\n"); 
		query.append(",	STV_DMG_RESPB_PTY_KWN_CD" ).append("\n"); 
		query.append(",	STV_DMG_RESPB_CD" ).append("\n"); 
		query.append(",	STV_DMG_RESPB_DESC" ).append("\n"); 
		query.append(",	DMG_EML_SND_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",   TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',UPD_DT,'GMT'), 'YYYY-MM-DD') AS UPD_DT" ).append("\n"); 
		query.append(",   STV_DMG_RPT_ATCH_KNT" ).append("\n"); 
		query.append(",	STV_DMG_PICT_ATCH_KNT" ).append("\n"); 
		query.append(",	STV_DMG_DOC_ATCH_KNT" ).append("\n"); 
		query.append("FROM OPF_STV_DMG_DTL" ).append("\n"); 
		query.append("WHERE	STV_DMG_NO = @[stv_dmg_no]" ).append("\n"); 

	}
}