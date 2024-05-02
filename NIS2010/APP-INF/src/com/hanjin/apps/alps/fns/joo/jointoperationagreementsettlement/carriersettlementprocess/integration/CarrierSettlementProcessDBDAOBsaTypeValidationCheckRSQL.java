/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOBsaTypeValidationCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.08.18 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOBsaTypeValidationCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Other Settlement 화면에서 S/H 에 대한 BSA Type을 선택할 경우 해당 VVD에 맞는 BSA Type인지 Validation을 체크하기 위한 SQL
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOBsaTypeValidationCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_stl_jb_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration ").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOBsaTypeValidationCheckRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN C.BSA_OP_JB_CD IN ('000','001') THEN '101'" ).append("\n"); 
		query.append("            WHEN C.BSA_OP_JB_CD IN ('002','003') THEN '102'" ).append("\n"); 
		query.append("            WHEN C.BSA_OP_JB_CD IN ('004','005') THEN '103'" ).append("\n"); 
		query.append("       END AS JO_STL_JB_CD" ).append("\n"); 
		query.append("FROM   BSA_VVD_CRR_PERF C" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("AND    C.CRR_PERF_AMT <> 0" ).append("\n"); 
		query.append("AND    C.CRR_CD     = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    C.TRD_CD     = @[trd_cd]" ).append("\n"); 
		query.append("AND    C.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("AND    C.VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND    C.SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    C.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    CASE WHEN C.BSA_OP_JB_CD IN ('001','002','004') THEN 'R'" ).append("\n"); 
		query.append("            WHEN C.BSA_OP_JB_CD IN ('000','003','005') THEN 'E'" ).append("\n"); 
		query.append("       END          = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    CASE WHEN C.BSA_OP_JB_CD IN ('000','001') THEN '101'" ).append("\n"); 
		query.append("            WHEN C.BSA_OP_JB_CD IN ('002','003') THEN '102'" ).append("\n"); 
		query.append("            WHEN C.BSA_OP_JB_CD IN ('004','005') THEN '103'" ).append("\n"); 
		query.append("       END          = @[jo_stl_jb_cd]" ).append("\n"); 

	}
}