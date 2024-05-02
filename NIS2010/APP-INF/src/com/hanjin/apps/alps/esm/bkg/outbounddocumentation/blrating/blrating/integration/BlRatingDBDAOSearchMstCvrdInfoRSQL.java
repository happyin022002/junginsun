/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BlRatingDBDAOSearchMstCvrdInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.09
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2010.06.09 김태경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author kim tae kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOSearchMstCvrdInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Master B/L을 업데이트 하기 위한 조건의 조회 실행
	  * </pre>
	  */
	public BlRatingDBDAOSearchMstCvrdInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("c_bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration").append("\n"); 
		query.append("FileName : BlRatingDBDAOSearchMstCvrdInfoRSQL").append("\n"); 
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
		query.append("DECODE(T1.POR_CD,'TWKEL','TWKHH',T1.POR_CD) AS MST_POR_CD --TWKEL,TWKHH 는 비지니스적으로 같다고 본다 2010.05.11 임종한 과장님요청" ).append("\n"); 
		query.append(",DECODE(T1.DEL_CD,'TWKEL','TWKHH',T1.DEL_CD) AS MST_DEL_CD --TWKEL,TWKHH 는 비지니스적으로 같다고 본다 2010.05.11 임종한 과장님요청 " ).append("\n"); 
		query.append(",T2.CUST_CNT_CD ||LPAD(T2.CUST_SEQ,6,0) AS MST_SHIPPER" ).append("\n"); 
		query.append(",T3.VSL_CD||T3.SKD_VOY_NO||T3.SKD_DIR_CD AS MST_VVD" ).append("\n"); 
		query.append(",T1.BKG_STS_CD AS MST_BKG_STS" ).append("\n"); 
		query.append(",DECODE(T4.POR_CD,'TWKEL','TWKHH',T4.POR_CD) AS COVER_POR_CD --TWKEL,TWKHH 는 비지니스적으로 같다고 본다 2010.05.11 임종한 과장님요청" ).append("\n"); 
		query.append(",DECODE(T4.DEL_CD,'TWKEL','TWKHH',T4.DEL_CD) AS COVER_DEL_CD --TWKEL,TWKHH 는 비지니스적으로 같다고 본다 2010.05.11 임종한 과장님요청" ).append("\n"); 
		query.append(",T5.CUST_CNT_CD||LPAD(T5.CUST_SEQ,6,0) AS COVER_SHIPPER" ).append("\n"); 
		query.append(",T6.VSL_CD||T6.SKD_VOY_NO||T6.SKD_DIR_CD AS COVER_VVD" ).append("\n"); 
		query.append(",T4.BKG_STS_CD AS COVER_BKG_STS" ).append("\n"); 
		query.append(",T7.CHG_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_BOOKING T1" ).append("\n"); 
		query.append(",BKG_CUSTOMER T2" ).append("\n"); 
		query.append(",BKG_VVD T3" ).append("\n"); 
		query.append(",BKG_BOOKING T4" ).append("\n"); 
		query.append(",BKG_CUSTOMER T5" ).append("\n"); 
		query.append(",BKG_VVD T6" ).append("\n"); 
		query.append(",(SELECT" ).append("\n"); 
		query.append("A1.BKG_NO ,A1.CHG_CD" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CHG_RT A1,BKG_BOOKING A2" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("A1.CHG_CD = 'OFT'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("AND A2.BL_NO = substr(@[bl_no],0,12) " ).append("\n"); 
		query.append("AND A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append(") T7" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("T1.BL_NO = substr(@[bl_no],0,12) " ).append("\n"); 
		query.append("AND T2.BKG_NO = T1.BKG_NO	" ).append("\n"); 
		query.append("AND T2.BKG_CUST_TP_CD = 'S'	" ).append("\n"); 
		query.append("AND T3.BKG_NO = T1.BKG_NO	" ).append("\n"); 
		query.append("AND T3.POL_CD = T1.POL_CD	" ).append("\n"); 
		query.append("AND T3.VSL_PRE_PST_CD IN ('T', 'S')	" ).append("\n"); 
		query.append("AND T4.BL_NO =  substr(@[c_bl_no],0,12) 	" ).append("\n"); 
		query.append("AND T5.BKG_NO = T4.BKG_NO	" ).append("\n"); 
		query.append("AND T5.BKG_CUST_TP_CD = 'S'	" ).append("\n"); 
		query.append("AND T6.BKG_NO = T4.BKG_NO	" ).append("\n"); 
		query.append("AND T6.POL_CD = T4.POL_CD	" ).append("\n"); 
		query.append("AND T6.VSL_PRE_PST_CD IN ('T', 'S')	" ).append("\n"); 
		query.append("AND T4.BKG_NO = T7.BKG_NO(+)" ).append("\n"); 

	}
}