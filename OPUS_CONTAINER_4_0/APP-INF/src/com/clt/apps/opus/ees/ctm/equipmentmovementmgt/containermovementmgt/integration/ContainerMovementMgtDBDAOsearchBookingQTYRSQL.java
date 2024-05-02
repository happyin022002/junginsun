/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOsearchBookingQTYRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.12.22 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM, Sang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOsearchBookingQTYRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 부킹번호에 해당하는 컨테이너 정보 조회
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOsearchBookingQTYRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOsearchBookingQTYRSQL").append("\n"); 
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
		query.append("SELECT Q.TS AS CNTR_TPSZ_CD," ).append("\n"); 
		query.append("Q.QTY AS OP_CNTR_QTY," ).append("\n"); 
		query.append("NVL (Q.QTY - A.CNT, 0) AS RENAIN," ).append("\n"); 
		query.append("A.TP AS BKG_CGO_TP_CD" ).append("\n"); 
		query.append("FROM (SELECT   C.CNTR_TPSZ_CD TS," ).append("\n"); 
		query.append("B.BKG_CGO_TP_CD TP," ).append("\n"); 
		query.append("SUM (C.CNTR_VOL_QTY) CNT" ).append("\n"); 
		query.append("FROM BKG_CONTAINER C," ).append("\n"); 
		query.append("BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND C.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_STS_CD NOT IN ('X', 'S')" ).append("\n"); 
		query.append("GROUP BY C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("B.BKG_CGO_TP_CD) A," ).append("\n"); 
		query.append("(SELECT CNTR_TPSZ_CD TS," ).append("\n"); 
		query.append("OP_CNTR_QTY QTY" ).append("\n"); 
		query.append("FROM BKG_QUANTITY Q" ).append("\n"); 
		query.append("WHERE Q.BKG_NO = @[bkg_no]) Q" ).append("\n"); 
		query.append("WHERE A.TS(+) = Q.TS" ).append("\n"); 

	}
}