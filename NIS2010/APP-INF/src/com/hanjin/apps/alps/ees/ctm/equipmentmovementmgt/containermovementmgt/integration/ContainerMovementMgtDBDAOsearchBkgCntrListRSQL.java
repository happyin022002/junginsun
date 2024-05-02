/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOsearchBkgCntrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2010.02.03 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOsearchBkgCntrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ContainerMovementMgtDBDAO
	  * SEARCH BOOKING CONTAINER LIST BY CONTAINER
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOsearchBkgCntrListRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOsearchBkgCntrListRSQL").append("\n"); 
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
		query.append("SELECT SUBSTR (CNT.CNTR_NO, 0, 10) CNTR_NO, SUBSTR (CNT.CNTR_NO, 11, 11) CHECK_DIGIT," ).append("\n"); 
		query.append("CNT.CNTR_TPSZ_CD, CNT.CNMV_STS_CD PREV_STS_CD, CNT.BKG_NO, CNT.RCV_TERM_CD," ).append("\n"); 
		query.append("CNT.CNMV_EVNT_DT" ).append("\n"); 
		query.append("FROM BKG_CONTAINER CNT, BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE CNT.CNMV_CYC_NO = '9999'" ).append("\n"); 
		query.append("AND CNT.BKG_NO = BKG.BKG_NO" ).append("\n"); 
		query.append("AND BKG.BKG_CGO_TP_CD != 'P'" ).append("\n"); 
		query.append("AND NVL(BKG.BKG_STS_CD,' ') <> 'S'" ).append("\n"); 
		query.append("AND NVL(BKG.BKG_STS_CD,' ') <> 'X'" ).append("\n"); 
		query.append("AND CNT.CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}