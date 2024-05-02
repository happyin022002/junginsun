/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOGetOldBkgNoForGateNewRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.18
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.12.18 김상수
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

public class ContainerMovementMgtDBDAOGetOldBkgNoForGateNewRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOGetOldBkgNoForGateNewRSQL(){
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
		query.append("FileName : ContainerMovementMgtDBDAOGetOldBkgNoForGateNewRSQL").append("\n"); 
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
		query.append("SELECT BO.BKG_NO" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BC, BKG_BOOKING BO" ).append("\n"); 
		query.append("WHERE BC.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("AND BC.CNMV_CYC_NO = 9999" ).append("\n"); 
		query.append("AND SYSDATE - BC.CRE_DT < 60" ).append("\n"); 
		query.append("AND BC.BKG_NO = BO.BKG_NO" ).append("\n"); 
		query.append("AND NVL (BO.BKG_STS_CD, '') <> 'S'" ).append("\n"); 
		query.append("AND NVL (BO.BKG_STS_CD, '') <> 'X'" ).append("\n"); 
		query.append("AND NVL (BO.BKG_STS_CD, '') <> DECODE (@[gate_io_cd], 'AE', 'A', 'UV', 'A', 'X')" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}