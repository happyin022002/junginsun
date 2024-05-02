/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAODecideStatusForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.12.09 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAODecideStatusForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 322 또는 322이 아닌 STATUS CODE를 판정  [GateNew Batch처리용]
	  * </pre>
	  */
	public ContainerMovementMgtDBDAODecideStatusForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_io",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("full_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sight_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAODecideStatusForGateNewRSQL").append("\n"); 
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
		query.append("SELECT NVL (MVMT_STS_CD, 'ER') AS SET_MVMTSTATUS" ).append("\n"); 
		query.append("FROM CTM_MVMT_STS_DCSN" ).append("\n"); 
		query.append("WHERE 1 = 1" ).append("\n"); 
		query.append("AND MVMT_EDI_MSG_TP_ID = @[msg_tp_id]" ).append("\n"); 
		query.append("#if (${msg_tp_id} == '322')" ).append("\n"); 
		query.append("AND MVMT_EDI_IO_BND_CD = DECODE (@[full_sts_cd], 'F', @[sight_cd], 'AH',  @[sight_cd], 'I')    /* MTY 는 Inbound 기준 */" ).append("\n"); 
		query.append("#elseif (${msg_tp_id} == 'OTH')" ).append("\n"); 
		query.append("AND MVMT_EDI_IO_BND_CD = DECODE (@[full_sts_cd], 'M', 'I', @[sight_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND MVMT_EDI_CNTR_STS_CD = @[full_sts_cd]" ).append("\n"); 
		query.append("AND MVMT_EDI_GATE_IO_CD = @[gate_io]" ).append("\n"); 

	}
}