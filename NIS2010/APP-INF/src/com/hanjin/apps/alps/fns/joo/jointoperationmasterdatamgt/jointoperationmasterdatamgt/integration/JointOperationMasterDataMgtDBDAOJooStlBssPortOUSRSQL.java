/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationMasterDataMgtDBDAOJooStlBssPortOUSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.06.29 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationMasterDataMgtDBDAOJooStlBssPortOUSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대상항차의 ITEM이 OUS인 경우 TDR/RDR을 Basis Port에서 가져온다.
	  * </pre>
	  */
	public JointOperationMasterDataMgtDBDAOJooStlBssPortOUSRSQL(){
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
		params.put("jo_stl_itm_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("B.INTG_CD_VAL_DP_DESC AS JO_MNU_NM" ).append("\n"); 
		query.append("FROM   JOO_STL_BSS_PORT A," ).append("\n"); 
		query.append("COM_INTG_CD_DTL  B" ).append("\n"); 
		query.append("WHERE  A.JO_STL_TGT_TP_CD = B.INTG_CD_VAL_CTNT" ).append("\n"); 
		query.append("AND    B.INTG_CD_ID = 'CD01867'" ).append("\n"); 
		query.append("AND    A.JO_CRR_CD  = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD   = @[rlane_cd]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    A.JO_STL_ITM_CD = @[jo_stl_itm_cd]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration ").append("\n"); 
		query.append("FileName : JointOperationMasterDataMgtDBDAOJooStlBssPortOUSRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}