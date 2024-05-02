/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : PickupReturnCyManageDBDAOSelectPickupReturnCyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickupReturnCyManageDBDAOSelectPickupReturnCyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SelectPickupReturnCy
	  * 2010.10.1 채창호 CHM-201006135-01 Pick Up & Return CY Export 화면 수정 요청
	  * 내용: PRD_PKUP_RTN_YD 테이블의 FULL_PKUP_RTN_YD_CD 컬럼 삭제
	  * </pre>
	  */
	public PickupReturnCyManageDBDAOSelectPickupReturnCyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lane_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cargo_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_flag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_del",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.integration").append("\n"); 
		query.append("FileName : PickupReturnCyManageDBDAOSelectPickupReturnCyRSQL").append("\n"); 
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
		query.append("	DECODE(delt_flg, 'Y', '1', '0') del_flag" ).append("\n"); 
		query.append("	, por_del_cd por_del" ).append("\n"); 
		query.append("	, pol_pod_cd pol_pod" ).append("\n"); 
		query.append("	, vsl_slan_cd lane_code" ).append("\n"); 
		query.append("	, io_bnd_cd bound_code" ).append("\n"); 
		query.append("	, spcl_cgo_cd cargo_type" ).append("\n"); 
		query.append("	, mty_pkup_rtn_yd_cd pickup_cy" ).append("\n"); 
		query.append("    , CRE_USR_ID, UPD_USR_ID,to_char(cre_DT,'yyyymmdd') CRE_DT, to_char(UPD_DT,'yyyymmdd') UPD_DT" ).append("\n"); 
		query.append("FROM prd_pkup_rtn_yd" ).append("\n"); 
		query.append("WHERE " ).append("\n"); 
		query.append("	por_del_cd LIKE @[por_del] || '%'" ).append("\n"); 
		query.append("	AND pol_pod_cd LIKE @[pol_pod] || '%'" ).append("\n"); 
		query.append("	AND vsl_slan_cd LIKE @[lane_code] || '%'" ).append("\n"); 
		query.append("	--AND io_bnd_cd IN ('O','B')" ).append("\n"); 
		query.append("	AND io_bnd_cd LIKE DECODE(@[bound_code], 'B', '%', @[bound_code])" ).append("\n"); 
		query.append("	AND spcl_cgo_cd LIKE DECODE(@[cargo_type], 'AL', '%', @[cargo_type])" ).append("\n"); 
		query.append("	AND NVL(delt_flg,'N') LIKE DECODE(@[del_flag], 'A', '%', @[del_flag])" ).append("\n"); 

	}
}