/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetPreCnmvCycNoForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2010.05.11 김상수
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

public class ContainerMovementMgtDBDAOGetPreCnmvCycNoForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetPreCnmvCycNoForGateNewRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_io_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOGetPreCnmvCycNoForGateNewRSQL").append("\n"); 
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
		query.append("B.BKG_NO," ).append("\n"); 
		query.append("A.CNMV_CYC_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER A, BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND A.CNMV_CYC_NO = (SELECT MAX (CNMV_CYC_NO)" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC, BKG_BOOKING BO" ).append("\n"); 
		query.append("WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("AND NVL (BO.BKG_STS_CD, '') <> 'X'" ).append("\n"); 
		query.append("AND NVL (BO.BKG_STS_CD, '') <> 'S'" ).append("\n"); 
		query.append("AND NVL (BO.BKG_STS_CD, '') <> DECODE (@[gate_io_cd], 'AE', 'A', 'UV', 'A', 'X')    /* 2008.12.16 */" ).append("\n"); 
		query.append("AND (BC.CNMV_CYC_NO <> 9999 OR (BC.CNMV_CYC_NO = 9999 AND SYSDATE - BC.CRE_DT < 30)))" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND NVL (B.BKG_STS_CD, '') <> 'X'" ).append("\n"); 
		query.append("AND NVL (B.BKG_STS_CD, '') <> 'S'" ).append("\n"); 
		query.append("AND NVL (B.BKG_STS_CD, '') <> DECODE (@[gate_io_cd], 'AE', 'A', 'UV', 'A', 'X')    /* 2008.12.16 */" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}