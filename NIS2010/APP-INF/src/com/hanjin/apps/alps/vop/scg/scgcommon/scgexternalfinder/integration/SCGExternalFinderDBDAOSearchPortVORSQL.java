/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SCGExternalFinderDBDAOSearchPortVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SCGExternalFinderDBDAOSearchPortVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * VVD내의 Port 목록 조회
	  * 2012.05.29 
	  * Ticket ID : 선처리
	  * 개발자 : 이준범
	  * Title : SPCL CGO APVL for Partner Lines 화면 수정
	  * Description: 
	  * 1) Sheet 헤더명 변경 ( CNTR -> CNTR Q’ty , Seq. -> Seq. (CNTR Q’ty) )
	  * 2) 조회 조건 추가 - CLPT_IND_SEQ
	  * </pre>
	  */
	public SCGExternalFinderDBDAOSearchPortVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.scgcommon.scgexternalfinder.integration").append("\n"); 
		query.append("FileName : SCGExternalFinderDBDAOSearchPortVORSQL").append("\n"); 
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
		query.append("       ML.LOC_CD" ).append("\n"); 
		query.append("     , ML.LOC_NM" ).append("\n"); 
		query.append("     , PS.VSL_CD" ).append("\n"); 
		query.append("     , PS.SKD_VOY_NO" ).append("\n"); 
		query.append("     , PS.SKD_DIR_CD" ).append("\n"); 
		query.append("     , PS.CLPT_SEQ" ).append("\n"); 
		query.append("     , PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , TO_CHAR(PS.VPS_ETA_DT,'YYYY-MM-DD HH:MI') VPS_ETA_DT" ).append("\n"); 
		query.append("     , PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("     , PS.YD_CD" ).append("\n"); 
		query.append("     , PS.SKD_CNG_STS_CD" ).append("\n"); 
		query.append("  FROM MDM_LOCATION ML" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD PS" ).append("\n"); 
		query.append(" WHERE ML.LOC_CD = PS.VPS_PORT_CD" ).append("\n"); 
		query.append("#if (${vsl_cd} != '') " ).append("\n"); 
		query.append("   AND PS.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '') " ).append("\n"); 
		query.append("   AND PS.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("   AND PS.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("#end  " ).append("\n"); 
		query.append("#if (${loc_cd} != '') " ).append("\n"); 
		query.append("   AND ML.LOC_CD = @[loc_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${clpt_ind_seq} != '') " ).append("\n"); 
		query.append("   AND PS.CLPT_IND_SEQ = @[clpt_ind_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(" GROUP BY" ).append("\n"); 
		query.append("       ML.LOC_CD" ).append("\n"); 
		query.append("     , ML.LOC_NM" ).append("\n"); 
		query.append("     , PS.VSL_CD" ).append("\n"); 
		query.append("     , PS.SKD_VOY_NO" ).append("\n"); 
		query.append("     , PS.SKD_DIR_CD" ).append("\n"); 
		query.append("     , PS.CLPT_SEQ" ).append("\n"); 
		query.append("     , PS.CLPT_IND_SEQ" ).append("\n"); 
		query.append("     , PS.VPS_ETA_DT" ).append("\n"); 
		query.append("     , PS.TURN_PORT_IND_CD" ).append("\n"); 
		query.append("     , PS.YD_CD" ).append("\n"); 
		query.append("     , PS.SKD_CNG_STS_CD" ).append("\n"); 
		query.append(" ORDER BY" ).append("\n"); 
		query.append("       PS.CLPT_SEQ" ).append("\n"); 

	}
}