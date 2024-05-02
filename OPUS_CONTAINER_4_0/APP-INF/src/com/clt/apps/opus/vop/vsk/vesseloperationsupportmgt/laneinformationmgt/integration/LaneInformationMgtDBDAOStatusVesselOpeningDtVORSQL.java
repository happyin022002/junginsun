/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneInformationMgtDBDAOStatusVesselOpeningDtVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.27 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneInformationMgtDBDAOStatusVesselOpeningDtVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search lane status vessel info.
	  * </pre>
	  */
	public LaneInformationMgtDBDAOStatusVesselOpeningDtVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_lane",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOStatusVesselOpeningDtVORSQL").append("\n"); 
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
		query.append("SELECT  MAX(OPEN_DT) AS	SVC_OPEN_DT,                                                                        " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,1,LOC))||DECODE(MAX(DECODE(ROWNUM,2,LOC)),NULL,NULL,'-')||                " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,2,LOC))||DECODE(MAX(DECODE(ROWNUM,3,LOC)),NULL,NULL,'-')||                " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,3,LOC))||DECODE(MAX(DECODE(ROWNUM,4,LOC)),NULL,NULL,'-')||                " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,4,LOC))||DECODE(MAX(DECODE(ROWNUM,5,LOC)),NULL,NULL,'-')||                " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,5,LOC))||DECODE(MAX(DECODE(ROWNUM,6,LOC)),NULL,NULL,'-')||                " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,6,LOC))||DECODE(MAX(DECODE(ROWNUM,7,LOC)),NULL,NULL,'-')||                " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,7,LOC))||DECODE(MAX(DECODE(ROWNUM,8,LOC)),NULL,NULL,'-')||                " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,8,LOC))||DECODE(MAX(DECODE(ROWNUM,9,LOC)),NULL,NULL,'-')||                " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,9,LOC))||DECODE(MAX(DECODE(ROWNUM,10,LOC)),NULL,NULL,'-')||               " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,10,LOC))||DECODE(MAX(DECODE(ROWNUM,11,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,11,LOC))||DECODE(MAX(DECODE(ROWNUM,12,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,12,LOC))||DECODE(MAX(DECODE(ROWNUM,13,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,13,LOC))||DECODE(MAX(DECODE(ROWNUM,14,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,14,LOC))||DECODE(MAX(DECODE(ROWNUM,15,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,15,LOC))||DECODE(MAX(DECODE(ROWNUM,16,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,16,LOC))||DECODE(MAX(DECODE(ROWNUM,17,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,17,LOC))||DECODE(MAX(DECODE(ROWNUM,18,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,18,LOC))||DECODE(MAX(DECODE(ROWNUM,19,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,19,LOC))||DECODE(MAX(DECODE(ROWNUM,20,LOC)),NULL,NULL,'-')||              " ).append("\n"); 
		query.append("        MAX(DECODE(ROWNUM,20,LOC)) PORT_ROT,                                                        " ).append("\n"); 
		query.append("        MAX(DAYS)                  AS	FRE,                                                             " ).append("\n"); 
		query.append("        MAX(RMK)                   AS	REMARK                                                           " ).append("\n"); 
		query.append("FROM    ( SELECT  DAYS,                                LOC,                                         " ).append("\n"); 
		query.append("                  --MIN(TO_CHAR(B.CRE_DT, 'RRRR.MM.DD')) OPEN_DT,   " ).append("\n"); 
		query.append("                  MIN(TO_CHAR(B.VPS_ETB_DT, 'RRRR-MM-DD')) OPEN_DT,                                   " ).append("\n"); 
		query.append("                  NVL(RMK, ' ')                        RMK                                          " ).append("\n"); 
		query.append("          FROM    ( SELECT  A.VSL_SLAN_CD LANE,  A.SVC_DUR_DYS DAYS,                                " ).append("\n"); 
		query.append("                            B.CLPT_SEQ    SEQ,   SUBSTR(B.PORT_CD, 3) LOC,  PF_SKD_RMK RMK          " ).append("\n"); 
		query.append("                    FROM    VSK_PF_SKD A, VSK_PF_SKD_DTL B                                          " ).append("\n"); 
		query.append("                    WHERE   A.VSL_SLAN_CD  = B.VSL_SLAN_CD                                          " ).append("\n"); 
		query.append("                    AND     A.PF_SVC_TP_CD = B.PF_SVC_TP_CD                                         " ).append("\n"); 
		query.append("                    AND     A.VSL_SLAN_CD  = @[svc_lane]" ).append("\n"); 
		query.append("                    --AND     SLAN_STND_FLG  = 'Y' ) A, VSK_PF_SKD B    " ).append("\n"); 
		query.append("                    AND     SLAN_STND_FLG  = 'Y' ) A, VSK_VSL_PORT_SKD B                                 " ).append("\n"); 
		query.append("          --WHERE   A.LANE  = B.VSL_SLAN_CD   " ).append("\n"); 
		query.append("            WHERE   A.LANE  = B.SLAN_CD                                                         " ).append("\n"); 
		query.append("          GROUP BY SEQ, DAYS, LOC, RMK )" ).append("\n"); 

	}
}