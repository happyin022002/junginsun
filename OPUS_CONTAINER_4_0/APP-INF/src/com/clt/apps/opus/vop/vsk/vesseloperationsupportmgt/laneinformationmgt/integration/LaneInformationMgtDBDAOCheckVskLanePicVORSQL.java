/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : LaneInformationMgtDBDAOCheckVskLanePicVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.03 
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

public class LaneInformationMgtDBDAOCheckVskLanePicVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PIC Search
	  * </pre>
	  */
	public LaneInformationMgtDBDAOCheckVskLanePicVORSQL(){
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
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_pic_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration").append("\n"); 
		query.append("FileName : LaneInformationMgtDBDAOCheckVskLanePicVORSQL").append("\n"); 
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
		query.append(",	VSL_OPR_CD" ).append("\n"); 
		query.append(",	LANE_MNG_USR_DESC" ).append("\n"); 
		query.append(",	USR_NM" ).append("\n"); 
		query.append(",	JB_DESC" ).append("\n"); 
		query.append(",	PIC_VSL_DESC" ).append("\n"); 
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
		query.append("AND		SLAN_CD = @[slan_cd]" ).append("\n"); 
		query.append("AND     RGN_SHP_OPR_CD = @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("#if (${vsl_opr_cd} != '') " ).append("\n"); 
		query.append("AND		VSL_OPR_CD = @[vsl_opr_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND		VSL_OPR_CD IS NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY SLAN_CD, LANE_PIC_SEQ" ).append("\n"); 

	}
}