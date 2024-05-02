/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOPortRestrictionRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.09
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.11.09 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOPortRestrictionRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [VO사용]PortRestriction
	  * </pre>
	  */
	public PortRestrictionDBDAOPortRestrictionRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOPortRestrictionRSQL").append("\n"); 
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
		query.append("SELECT  ''restric_regyn," ).append("\n"); 
		query.append("A.PORT_CD                       ," ).append("\n"); 
		query.append("(SELECT   E.LOC_NM" ).append("\n"); 
		query.append("FROM    MDM_LOCATION E WHERE E.LOC_CD = A.PORT_CD )PORT_CD_NM," ).append("\n"); 
		query.append("A.IMDG_PORT_RSTR_SEQ            ," ).append("\n"); 
		query.append("A.IMDG_PORT_RSTR_EXPT_FLG       ," ).append("\n"); 
		query.append("A.IMDG_UN_NO                    ," ).append("\n"); 
		query.append("A.IMDG_UN_NO_SEQ                ," ).append("\n"); 
		query.append("A.IMDG_CLSS_CD                  ," ).append("\n"); 
		query.append("A.PROHI_LOD_FLG," ).append("\n"); 
		query.append("A.PROHI_DCHG_FLG                ," ).append("\n"); 
		query.append("A.PROHI_TS_FLG                  ," ).append("\n"); 
		query.append("A.PROHI_PASS_FLG                ," ).append("\n"); 
		query.append("A.PROHI_DY_TM_OP_FLG            ," ).append("\n"); 
		query.append("A.PROHI_DY_TM_INLND_TZ_FLG      ," ).append("\n"); 
		query.append("A.PROHI_PORT_FLG                ," ).append("\n"); 
		query.append("A.PROHI_PINSP_FLG               ," ).append("\n"); 
		query.append("A.XTRA_HNDL_CHG_FLG             ," ).append("\n"); 
		query.append("A.SFT_GAD_FLG                   ," ).append("\n"); 
		query.append("A.KEP_SFT_DIST_IHB_FLG          ," ).append("\n"); 
		query.append("A.KEP_SFT_DIST_IHB_DIST         ," ).append("\n"); 
		query.append("A.RSTR_RMK                      ," ).append("\n"); 
		query.append("A.PROHI_NGT_FLG                 ," ).append("\n"); 
		query.append("A.DIR_LOD_FLG                   ," ).append("\n"); 
		query.append("A.DIR_DCHG_FLG                  ," ).append("\n"); 
		query.append("A.DIR_TS_FLG                    ," ).append("\n"); 
		query.append("A.CRE_USR_ID                    ," ).append("\n"); 
		query.append("A.CRE_DT                        ," ).append("\n"); 
		query.append("A.UPD_USR_ID                    ," ).append("\n"); 
		query.append("A.UPD_DT  ," ).append("\n"); 
		query.append("TO_CHAR( A.UPD_DT,'YYYY-MM-DD HH24:MI') UPD_DT_F," ).append("\n"); 
		query.append("'' STO_DYS   ," ).append("\n"); 
		query.append("'' LOAD_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("'' DIS_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("''  TS_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("''  PASS_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("'' LOAD_STO_DYS ," ).append("\n"); 
		query.append("'' DIS_STO_DYS ," ).append("\n"); 
		query.append("'' TS_STO_DYS  ," ).append("\n"); 
		query.append("'' LOAD_DYS_STO_FLG ," ).append("\n"); 
		query.append("'' DIS_DYS_STO_FLG  ," ).append("\n"); 
		query.append("'' TS_DYS_STO_FLG  ," ).append("\n"); 
		query.append("'1'     sav_type_class_flag," ).append("\n"); 
		query.append("'Class' sav_type_class_label," ).append("\n"); 
		query.append("'1'     sav_type_unno_flag," ).append("\n"); 
		query.append("'UN No.' sav_type_unno_label," ).append("\n"); 
		query.append("''imdg_clss_cd_txt," ).append("\n"); 
		query.append("''IMDG_CLSS_CD_DESC," ).append("\n"); 
		query.append("''UNNO_EXIST_YN" ).append("\n"); 
		query.append("FROM    SCG_IMDG_PORT_RSTR A" ).append("\n"); 
		query.append("WHERE ROWNUM=1" ).append("\n"); 

	}
}