/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchEur24ItarySeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.03.18
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2011.03.18 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Gyoung Sub
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchEur24ItarySeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchEur24ItarySeqRSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchEur24ItarySeqRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("it_seq_n",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchEur24ItarySeqRSQL").append("\n"); 
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
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_LOCAL_FNC('ITROM'),'MMDD')||LPAD(IT_SEQ_N ,4,'0') AS  IT_SEQ /* 8 */" ).append("\n"); 
		query.append(",CASE  WHEN B<10 THEN TO_CHAR(B)" ).append("\n"); 
		query.append("       WHEN 9< B AND B <= 35 THEN CHR( TO_NUMBER(B)+55  )  /*10~35 에 대한 영문대문자 치환. A=65 이므로 +55*/" ).append("\n"); 
		query.append("       WHEN 35<B AND B <= 61 THEN CHR( TO_NUMBER(B)+61  )  /*35~61 에 대한 영문소문자 치환. a=97 이므로 +61*/" ).append("\n"); 
		query.append(" END ||" ).append("\n"); 
		query.append(" CASE WHEN C<10 THEN TO_CHAR(C)" ).append("\n"); 
		query.append("      WHEN 9< C AND C <= 35 THEN CHR( TO_NUMBER(C)+55  )  /*10~35 에 대한 영문대문자 치환*/" ).append("\n"); 
		query.append("      WHEN 35<C AND C <= 61 THEN CHR( TO_NUMBER(C)+61  )  /*35~61 에 대한 영문소문자 치환*/" ).append("\n"); 
		query.append(" END AS IT_FILE_SEQ /* 9 */" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("        SELECT" ).append("\n"); 
		query.append("           DECODE(FLOOR( FLOOR(IT_SEQ_N/62) /62 ),0, FLOOR(IT_SEQ_N/62), FLOOR( FLOOR(IT_SEQ_N/62) /62 ))  B" ).append("\n"); 
		query.append("         , DECODE(FLOOR( MOD(IT_SEQ_N,62) /62 ),0, MOD(IT_SEQ_N,62), MOD( MOD(IT_SEQ_N,62) ,62 ))  C" ).append("\n"); 
		query.append("         , IT_SEQ_N" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("                 SELECT TO_NUMBER(@[it_seq_n]) AS IT_SEQ_N FROM DUAL " ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}