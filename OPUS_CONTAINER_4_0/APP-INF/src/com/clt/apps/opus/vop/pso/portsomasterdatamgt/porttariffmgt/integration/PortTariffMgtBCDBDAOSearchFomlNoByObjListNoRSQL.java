/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchFomlNoByObjListNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.18 정명훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchFomlNoByObjListNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [VOP_PSO_0002화면 전용] OBJECT_LIST_NO와 Rate_Type으로 FORMULA_NO를 조회한다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchFomlNoByObjListNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_trf_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_obj_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchFomlNoByObjListNoRSQL").append("\n"); 
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
		query.append("SELECT A.FOML_NO" ).append("\n"); 
		query.append(",A.FOML_NM" ).append("\n"); 
		query.append(",A.PSO_FOML_MZD_CD" ).append("\n"); 
		query.append(",A.FOML_DESC" ).append("\n"); 
		query.append(",A.FOML_SYS_DESC" ).append("\n"); 
		query.append("FROM   PSO_FORMULA  A" ).append("\n"); 
		query.append(",PSO_FOML_DTL B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    B.OBJ_LIST_NO = 45" ).append("\n"); 
		query.append("AND    B.RT_OBJ_LIST_NO = (SELECT OBJ_LIST_NO" ).append("\n"); 
		query.append("FROM   PSO_OBJ_LIST" ).append("\n"); 
		query.append("WHERE  PSO_OBJ_CD = @[pso_obj_cd]" ).append("\n"); 
		query.append("AND    PSO_MEAS_UT_CD = @[pso_meas_ut_cd])" ).append("\n"); 
		query.append("AND    B.FOML_SEQ = DECODE(@[pso_trf_tp_cd], 'R', 3, 'S', 1, 'F', 3)" ).append("\n"); 
		query.append("AND    B.FOML_NO = A.FOML_NO" ).append("\n"); 
		query.append("AND    A.UPD_MNU_NO = 1" ).append("\n"); 

	}
}