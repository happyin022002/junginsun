/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : LaneInformationMgtDBDAOStatusVesselVSLNameVORSQL.java
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

public class LaneInformationMgtDBDAOStatusVesselVSLNameVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search lane status vessel info.
	  * </pre>
	  */
	public LaneInformationMgtDBDAOStatusVesselVSLNameVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_class",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_lane",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("opt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOStatusVesselVSLNameVORSQL").append("\n"); 
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
		query.append("SELECT MAX(DECODE(ROWNUM,1,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,2,VSL_CD)),NULL,NULL,'/')||         " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,2,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,3,VSL_CD)),NULL,NULL,'/')||         " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,3,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,4,VSL_CD)),NULL,NULL,'/')||         " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,4,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,5,VSL_CD)),NULL,NULL,'/')||         " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,5,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,6,VSL_CD)),NULL,NULL,'/')||         " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,6,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,7,VSL_CD)),NULL,NULL,'/')||         " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,7,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,8,VSL_CD)),NULL,NULL,'/')||         " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,8,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,9,VSL_CD)),NULL,NULL,'/')||         " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,9,VSL_CD))||DECODE(MAX(DECODE(ROWNUM,10,VSL_CD)),NULL,NULL,'/')||        " ).append("\n"); 
		query.append("       MAX(DECODE(ROWNUM,10,VSL_CD)) VSL_NM                                                       " ).append("\n"); 
		query.append("FROM ( SELECT  DISTINCT A.VSL_CD, A.SLAN_CD, NVL(B.CNTR_VSL_CLSS_CAPA, 0) CLASS                   " ).append("\n"); 
		query.append("       FROM    VSK_VSL_PORT_SKD A, MDM_VSL_CNTR B                                                 " ).append("\n"); 
		query.append("       WHERE   A.SLAN_CD    = @[svc_lane]" ).append("\n"); 
		query.append("       AND     A.VPS_ETB_DT > SYSDATE                                                             " ).append("\n"); 
		query.append("       AND     A.VPS_ETB_DT < SYSDATE + 90                                                        " ).append("\n"); 
		query.append("       AND     A.VSL_CD     = B.VSL_CD                                                            " ).append("\n"); 
		query.append("       AND     NVL(B.CNTR_VSL_CLSS_CAPA, 0) = @[vsl_class]" ).append("\n"); 
		query.append("       AND     B.CRR_CD = @[opt]" ).append("\n"); 
		query.append("     )" ).append("\n"); 

	}
}