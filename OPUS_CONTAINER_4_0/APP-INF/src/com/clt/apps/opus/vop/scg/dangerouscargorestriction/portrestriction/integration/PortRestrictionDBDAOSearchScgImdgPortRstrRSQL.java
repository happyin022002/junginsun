/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PortRestrictionDBDAOSearchScgImdgPortRstrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOSearchScgImdgPortRstrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOSearchScgImdgPortRstrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOSearchScgImdgPortRstrRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("        A.PORT_CD                       ," ).append("\n"); 
		query.append("        (SELECT   E.LOC_NM" ).append("\n"); 
		query.append("          FROM    MDM_LOCATION E WHERE E.LOC_CD = A.PORT_CD )PORT_CD_NM," ).append("\n"); 
		query.append("        A.IMDG_PORT_RSTR_SEQ            ," ).append("\n"); 
		query.append("        A.IMDG_PORT_RSTR_EXPT_FLG       ," ).append("\n"); 
		query.append("        A.IMDG_UN_NO                    ," ).append("\n"); 
		query.append("        A.IMDG_UN_NO_SEQ                ," ).append("\n"); 
		query.append("        A.IMDG_CLSS_CD                  ," ).append("\n"); 
		query.append("        A.PROHI_LOD_FLG," ).append("\n"); 
		query.append("        A.PROHI_DCHG_FLG                ," ).append("\n"); 
		query.append("        A.PROHI_TS_FLG                  ," ).append("\n"); 
		query.append("        A.PROHI_PASS_FLG                ," ).append("\n"); 
		query.append("        A.PROHI_DY_TM_OP_FLG            ," ).append("\n"); 
		query.append("        A.PROHI_DY_TM_INLND_TZ_FLG      ," ).append("\n"); 
		query.append("        A.PROHI_PORT_FLG                ," ).append("\n"); 
		query.append("        A.PROHI_PINSP_FLG               ," ).append("\n"); 
		query.append("        A.XTRA_HNDL_CHG_FLG             ," ).append("\n"); 
		query.append("        A.SFT_GAD_FLG                   ," ).append("\n"); 
		query.append("        A.KEP_SFT_DIST_IHB_FLG          ," ).append("\n"); 
		query.append("        A.KEP_SFT_DIST_IHB_DIST         ," ).append("\n"); 
		query.append("        A.RSTR_RMK                      ," ).append("\n"); 
		query.append("        A.PROHI_NGT_FLG                 ," ).append("\n"); 
		query.append("        A.DIR_LOD_FLG                   ," ).append("\n"); 
		query.append("        A.DIR_DCHG_FLG                  ," ).append("\n"); 
		query.append("        A.DIR_TS_FLG                    ," ).append("\n"); 
		query.append("        A.CRE_USR_ID                    ," ).append("\n"); 
		query.append("        A.CRE_DT                        ," ).append("\n"); 
		query.append("        A.UPD_USR_ID                    ," ).append("\n"); 
		query.append("        A.UPD_DT  ," ).append("\n"); 
		query.append("        TO_CHAR(NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),A.UPD_DT,'GMT'), A.UPD_DT),'YYYY-MM-DD HH24:MI') UPD_DT_F," ).append("\n"); 
		query.append("        '' STO_DYS   ," ).append("\n"); 
		query.append("        '' LOAD_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("        '' DIS_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("        ''  TS_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("        ''  PASS_IMDG_CMPTN_AUTH_CD," ).append("\n"); 
		query.append("	    '' LOAD_STO_DYS ," ).append("\n"); 
		query.append("        '' DIS_STO_DYS ," ).append("\n"); 
		query.append("        '' TS_STO_DYS  ," ).append("\n"); 
		query.append("        '' LOAD_DYS_STO_FLG , " ).append("\n"); 
		query.append("        '' DIS_DYS_STO_FLG  ," ).append("\n"); 
		query.append("        '' TS_DYS_STO_FLG  ," ).append("\n"); 
		query.append("        '1'     sav_type_class_flag," ).append("\n"); 
		query.append("        'Class' sav_type_class_label," ).append("\n"); 
		query.append("        '1'     sav_type_unno_flag," ).append("\n"); 
		query.append("        'UN No.' sav_type_unno_label," ).append("\n"); 
		query.append("        ''imdg_clss_cd_txt" ).append("\n"); 
		query.append("FROM    SCG_IMDG_PORT_RSTR A" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("#if (${port_cd} != '' ) " ).append("\n"); 
		query.append("     A.PORT_CD             =  @[port_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${imdg_clss_cd} != '' && ${imdg_un_no} == '' ) " ).append("\n"); 
		query.append("  AND   A.IMDG_CLSS_CD  =  @[imdg_clss_cd]" ).append("\n"); 
		query.append("  AND   A.IMDG_UN_NO  IS NULL" ).append("\n"); 
		query.append("  AND   A.IMDG_UN_NO_SEQ IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if ( ${imdg_un_no} != ''  ) " ).append("\n"); 
		query.append("  AND   IMDG_UN_NO  =  @[imdg_un_no]" ).append("\n"); 
		query.append("  AND   IMDG_UN_NO_SEQ  =  @[imdg_un_no_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}