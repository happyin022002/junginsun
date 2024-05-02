/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : LaneInformationMgtDBDAOVskLanePicVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.28
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.04.28 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LaneInformationMgtDBDAOVskLanePicVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Lane PIC 정보를 조회 합니다.
	  * ===============================================
	  * History
	  * 2011.04.28 진마리아 [CHM-201110229-01] Lane informtion내 PIC의 Vessel 칼럼을 Carrier로 변경 요청건
	  * </pre>
	  */
	public LaneInformationMgtDBDAOVskLanePicVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_pic_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOVskLanePicVORSQL").append("\n"); 
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
		query.append("	SLAN_CD" ).append("\n"); 
		query.append(",	LANE_PIC_SEQ" ).append("\n"); 
		query.append(",	RGN_SHP_OPR_CD" ).append("\n"); 
		query.append(",	LANE_PIC_TP_CD" ).append("\n"); 
		query.append(",	VSL_SLAN_NM" ).append("\n"); 
		query.append(",	LANE_MNG_USR_DESC" ).append("\n"); 
		query.append(",	USR_NM" ).append("\n"); 
		query.append(",	JB_DESC" ).append("\n"); 
		query.append(",	PIC_VSL_DESC" ).append("\n"); 
		query.append(",	PIC_CRR_DESC" ).append("\n"); 
		query.append(",	PIC_PHN_NO" ).append("\n"); 
		query.append(",	MPHN_NO" ).append("\n"); 
		query.append(",	FAX_NO" ).append("\n"); 
		query.append(",	LANE_PIC_USR_EML" ).append("\n"); 
		query.append(",	PIC_EML" ).append("\n"); 
		query.append(",	LANE_RMK" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	TO_CHAR(UPD_DT, 'YYYY-MM-DD HH24:MI') AS UPD_DT" ).append("\n"); 
		query.append("FROM VSK_LANE_PIC" ).append("\n"); 
		query.append("WHERE	LANE_PIC_TP_CD = @[lane_pic_tp_cd]" ).append("\n"); 
		query.append("#if (${slan_cd} != '') " ).append("\n"); 
		query.append("AND		SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SLAN_CD, LANE_PIC_SEQ" ).append("\n"); 

	}
}