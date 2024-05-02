/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOcheckChsBareMvmtByopocDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2009.11.10 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOcheckChsBareMvmtByopocDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOcheckChsBareMvmtByopocDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOcheckChsBareMvmtByopocDataRSQL").append("\n"); 
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
		query.append("SELECT /*+ INDEX_DESC(B XPKCGM_CHSS_MVMT_HIS ) */" ).append("\n"); 
		query.append("A.CHSS_NO CHSS_NO" ).append("\n"); 
		query.append(", TO_CHAR(A.MVMT_DT,'YYYYMMDDHH24MISS') MVMT_DT_1" ).append("\n"); 
		query.append(", TO_CHAR(B.MVMT_DT,'YYYYMMDDHH24MISS') MVMT_DT_2" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT /*+ INDEX_DESC(A XAK1CGM_CHSS_MVMT_HIS) */" ).append("\n"); 
		query.append("A.CHSS_NO" ).append("\n"); 
		query.append(",A.GATE_IO_CD" ).append("\n"); 
		query.append(",A.MVMT_DT" ).append("\n"); 
		query.append("FROM   CGM_CHSS_MVMT_HIS A, MDM_LOCATION B , MDM_EQ_ORZ_CHT C" ).append("\n"); 
		query.append("WHERE  A.CNTR_NO  = @[cntr_no]" ).append("\n"); 
		query.append("AND    B.LOC_CD   = SUBSTR(A.YD_CD, 1, 5)" ).append("\n"); 
		query.append("AND    C.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND    C.LCC_CD = ( SELECT  B.LCC_CD FROM MDM_LOCATION A , MDM_EQ_ORZ_CHT B" ).append("\n"); 
		query.append("WHERE A.SCC_CD = B.SCC_CD" ).append("\n"); 
		query.append("AND A.LOC_CD = substr(@[org_yd_cd],0,5)" ).append("\n"); 
		query.append("AND ROWNUM=1 )" ).append("\n"); 
		query.append("AND    A.CHSS_NO <> @[chss_no]" ).append("\n"); 
		query.append("AND    A.MVMT_STS_CD= 'MT'" ).append("\n"); 
		query.append("AND    ROWNUM      = 1" ).append("\n"); 
		query.append(") A, CGM_CHSS_MVMT_HIS B, CGM_EQUIPMENT C" ).append("\n"); 
		query.append("WHERE B.CHSS_NO =A.CHSS_NO" ).append("\n"); 
		query.append("AND B.CHSS_NO = C.EQ_NO" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}