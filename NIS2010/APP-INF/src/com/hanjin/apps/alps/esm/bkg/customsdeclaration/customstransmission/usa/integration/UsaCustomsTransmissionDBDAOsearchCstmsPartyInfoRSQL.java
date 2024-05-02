/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchCstmsPartyInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.09
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2012.07.09 이영헌
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author YoungHeon Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchCstmsPartyInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCstmsPartyInfo
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchCstmsPartyInfoRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchCstmsPartyInfoRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append(" RPAD('N00'||RPAD(BKG_SPCLCHAR_CONV_FNC(  A.CSTMS_PTY_TP_CD , 'X' ),3,' ')  ||" ).append("\n"); 
		query.append("             RPAD( NVL( RTRIM(BKG_SPCLCHAR_CONV_FNC( RTRIM(A.CSTMS_PTY_NM), 'X')  ),' ')           , 35,' ')||" ).append("\n"); 
		query.append("             RPAD(BKG_SPCLCHAR_CONV_FNC(  DECODE( A.CSTMS_PTY_TP_CD, 'CB','17','SNP','2') , 'X' ),2,' ')||" ).append("\n"); 
		query.append("		     RPAD( NVL( RTRIM(BKG_SPCLCHAR_CONV_FNC( RTRIM(  A.CSTMS_PTY_ID ), 'X')  ),' ') ,17,' '),80,' ') BUF27" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_ORZ_PTY A, BKG_BOOKING BK, BKG_CSTMS_ADV_BL C, BKG_CSTMS_ADV_CUST D" ).append("\n"); 
		query.append("WHERE C.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("AND C.CNT_CD='US'" ).append("\n"); 
		query.append("AND C.BKG_NO = BK.BKG_NO" ).append("\n"); 
		query.append("AND C.CNT_CD=D.CNT_cD" ).append("\n"); 
		query.append("AND C.BL_NO = D.BL_NO" ).append("\n"); 
		query.append("AND D.BKG_CUST_TP_CD = DECODE(BK.CUST_TO_ORD_FLG, 'Y', 'N', 'C')" ).append("\n"); 
		query.append("AND NVL(A.CUST_CNT_CD, 'XXX') IN ('XXX', D.CUST_CNT_CD)" ).append("\n"); 
		query.append("AND NVL(A.CUST_SEQ, 999999) IN (999999, D.CUST_SEQ)" ).append("\n"); 
		query.append("AND NVL(A.SC_NO, 'XXX') IN('XXX', BK.SC_NO)" ).append("\n"); 
		query.append("AND NVL(A.POD_CD, 'XXX') IN ('XXX', C.POD_CD)" ).append("\n"); 
		query.append("AND NVL(A.DEL_CD, 'XXX') IN ('XXX', C.DEL_CD)" ).append("\n"); 
		query.append("AND NVL(A.POD_YD_NO,'XX') = DECODE( A.POD_YD_NO,null ,'XX',   SUBSTR(C.POD_NOD_CD,6,2)  ) " ).append("\n"); 
		query.append("AND NVL(A.DEL_YD_NO,'XX') = DECODE( A.DEL_YD_NO,null ,'XX',   SUBSTR(C.DEL_NOD_CD,6,2)  ) " ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 

	}
}