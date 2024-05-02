/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : PickupReturnCyManageDBDAOSelectPickupReturnCyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

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
		params.put("spcl_cgo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.integration").append("\n"); 
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
		query.append("SELECT POR_DEL_CD, POL_POD_CD, VSL_SLAN_CD, IO_BND_CD, SPCL_CGO_CD, MTY_PKUP_RTN_YD_CD, CNTR_TP_CD, CNTR_SZ_CD, DECODE(DELT_FLG, 'Y', 1, 0) DELT_FLG, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append("  FROM PRD_PKUP_RTN_YD" ).append("\n"); 
		query.append(" WHERE POR_DEL_CD LIKE @[por_del_cd] || '%'" ).append("\n"); 
		query.append("   AND POL_POD_CD LIKE @[pol_pod_cd] || '%'" ).append("\n"); 
		query.append("   AND VSL_SLAN_CD LIKE @[vsl_slan_cd] || '%'" ).append("\n"); 
		query.append("   AND IO_BND_CD = DECODE(@[io_bnd_cd], 'AL', IO_BND_CD, @[io_bnd_cd])" ).append("\n"); 
		query.append("   AND SPCL_CGO_CD =  DECODE(@[spcl_cgo_cd], 'AL', SPCL_CGO_CD, @[spcl_cgo_cd])" ).append("\n"); 
		query.append("   AND DELT_FLG =  DECODE(@[delt_flg], 'A', DELT_FLG, @[delt_flg])" ).append("\n"); 

	}
}