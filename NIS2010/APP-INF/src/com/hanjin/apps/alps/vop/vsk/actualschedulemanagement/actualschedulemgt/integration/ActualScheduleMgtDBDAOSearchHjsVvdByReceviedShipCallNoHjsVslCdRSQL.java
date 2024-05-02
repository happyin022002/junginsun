/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoHjsVslCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoHjsVslCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수신된 CONVEYANCE REFERENCE NUMBER (SHIP CALL NO.) MYPKG에서 사용하는 NO , SML Vessel Code, Yard Code를 이용한 SML에 맵핑되는 VVD를 조회한다.
	  * --------------------------------------------------------------------
	  * 2011.10.17 진마리아 CHM-201113948 Vessel sked EDI의 VVD mapping을 위해 F/F 수정 (Segment추가) (UAX)
	  * 2011.10.27 진마리아 CHM-201114330 Vessel sked EDI의 VVD mapping을 위해 F/F 수정 (Segment추가) : BOOK_* -> BKG_*
	  * 2011.12.26 진마리아 CHM-201115228 VVD mapping 위한 mtch mode 관련 수정(and 누락 수정)
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoHjsVslCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("shp_call_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchHjsVvdByReceviedShipCallNoHjsVslCdRSQL").append("\n"); 
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
		query.append("SELECT		T2.VSL_CD" ).append("\n"); 
		query.append("		, 	T2.SKD_VOY_NO" ).append("\n"); 
		query.append("		, 	T2.SKD_DIR_CD" ).append("\n"); 
		query.append("FROM		BKG_VSL_DCHG_YD 	T1" ).append("\n"); 
		query.append("		, 	VSK_VSL_PORT_SKD 	T2" ).append("\n"); 
		query.append("WHERE		1 = 1" ).append("\n"); 
		query.append("AND			T1.VSL_CD			= T2.VSL_CD" ).append("\n"); 
		query.append("AND			T1.SKD_VOY_NO		= T2.SKD_VOY_NO" ).append("\n"); 
		query.append("AND			T1.SKD_DIR_CD		= T2.SKD_DIR_CD" ).append("\n"); 
		query.append("AND			T1.PORT_CD			= T2.VPS_PORT_CD" ).append("\n"); 
		query.append("AND			T1.CLPT_IND_SEQ		= T2.CLPT_IND_SEQ" ).append("\n"); 
		query.append("AND			'S'            		!= NVL(T2.SKD_CNG_STS_CD, ' ')" ).append("\n"); 
		query.append("#if (${mtch_mod_cd} == 'BKG_UVI') " ).append("\n"); 
		query.append("AND     	T1.UQ_VSL_ID_NO 	= @[shp_call_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mtch_mod_cd} == 'BKG_CRN') " ).append("\n"); 
		query.append("AND			T1.CVY_REF_NO		= @[shp_call_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND     	T2.YD_CD        	= @[yd_cd]" ).append("\n"); 
		query.append("AND     	T2.TURN_PORT_IND_CD NOT IN ('D', 'V', 'F')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND			T2.VPS_ETB_DT		> SYSDATE - 730		--[2014-01-11::2년이전데이터 무시]--" ).append("\n"); 

	}
}