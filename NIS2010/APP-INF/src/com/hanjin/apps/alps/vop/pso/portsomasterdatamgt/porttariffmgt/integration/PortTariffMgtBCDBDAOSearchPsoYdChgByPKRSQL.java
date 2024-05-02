/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOSearchPsoYdChgByPKRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.17
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.09.17 정명훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Myounghun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOSearchPsoYdChgByPKRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * PSO_YD_CHG, PSO_CHG_DTL <OUTER JOIN>
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOSearchPsoYdChgByPKRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_chg_ver_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOSearchPsoYdChgByPKRSQL").append("\n"); 
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
		query.append("SELECT A.YD_CHG_NO" ).append("\n"); 
		query.append(",A.YD_CHG_VER_SEQ" ).append("\n"); 
		query.append(",A.LGS_COST_CD" ).append("\n"); 
		query.append(",A.YD_CD" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",TO_CHAR(A.EFF_DT, 'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(A.EXP_DT, 'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.CPLS_FLG" ).append("\n"); 
		query.append(",A.ORG_VNDR_NM" ).append("\n"); 
		query.append(",A.RLT_AGMT_NO" ).append("\n"); 
		query.append(",A.LST_FLG" ).append("\n"); 
		query.append(",NVL(B.ISS_CTY_CD, 'X')         CRE_USR_ID  --PSO_CHG_DTL 테이블에 값이 있는지 확인하기 위하여" ).append("\n"); 
		query.append("FROM   PSO_YD_CHG A" ).append("\n"); 
		query.append(",PSO_CHG_DTL B" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    A.YD_CHG_NO = B.YD_CHG_NO(+)" ).append("\n"); 
		query.append("AND    A.YD_CHG_VER_SEQ = B.YD_CHG_VER_SEQ(+)" ).append("\n"); 
		query.append("AND    A.YD_CHG_NO = @[yd_chg_no]" ).append("\n"); 
		query.append("AND    A.YD_CHG_VER_SEQ = @[yd_chg_ver_seq]" ).append("\n"); 

	}
}