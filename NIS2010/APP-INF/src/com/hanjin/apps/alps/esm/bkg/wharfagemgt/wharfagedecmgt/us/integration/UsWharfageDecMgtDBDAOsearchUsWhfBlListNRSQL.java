/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsWharfageDecMgtDBDAOsearchUsWhfBlListNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.08.20 김민정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Minjung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsWharfageDecMgtDBDAOsearchUsWhfBlListNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchUsWhfBlListN
	  * </pre>
	  */
	public UsWharfageDecMgtDBDAOsearchUsWhfBlListNRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("port",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bound",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.integration").append("\n"); 
		query.append("FileName : UsWharfageDecMgtDBDAOsearchUsWhfBlListNRSQL").append("\n"); 
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
		query.append("SELECT  A.BL_NO" ).append("\n"); 
		query.append(",A.BKG_NO" ).append("\n"); 
		query.append(",E.CNTR_NO" ).append("\n"); 
		query.append(",CASE WHEN A.BKG_CGO_TP_CD = 'F' THEN 'Full'" ).append("\n"); 
		query.append("WHEN A.BKG_CGO_TP_CD IN ('P','R') THEN 'Empty'" ).append("\n"); 
		query.append("ELSE ''" ).append("\n"); 
		query.append("END FM" ).append("\n"); 
		query.append(",D.CSTMS_DESC" ).append("\n"); 
		query.append(",'' AS USA_WHF_EXPT_FLG" ).append("\n"); 
		query.append(",A.DEL_CD" ).append("\n"); 
		query.append(",DECODE(@[bound], 'I', A.DE_TERM_CD, A.RCV_TERM_CD) AS TERM" ).append("\n"); 
		query.append(",'' AS USA_WHF_TP_CD" ).append("\n"); 
		query.append(",CASE SUBSTR(E.CNTR_TPSZ_CD,2)" ).append("\n"); 
		query.append("WHEN '2' THEN E.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN '3' THEN E.CNTR_VOL_QTY" ).append("\n"); 
		query.append("END FT20" ).append("\n"); 
		query.append(",CASE SUBSTR(E.CNTR_TPSZ_CD,2)" ).append("\n"); 
		query.append("WHEN '4' THEN E.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN '5' THEN E.CNTR_VOL_QTY" ).append("\n"); 
		query.append("END FT40" ).append("\n"); 
		query.append(",CASE SUBSTR(E.CNTR_TPSZ_CD,2)" ).append("\n"); 
		query.append("WHEN '6' THEN E.CNTR_VOL_QTY" ).append("\n"); 
		query.append("WHEN '7' THEN E.CNTR_VOL_QTY" ).append("\n"); 
		query.append("END FT45" ).append("\n"); 
		query.append(",'' WHF_FLG" ).append("\n"); 
		query.append(",'' PORT" ).append("\n"); 
		query.append(",'' VVD" ).append("\n"); 
		query.append(",'' BOUND" ).append("\n"); 
		query.append(",'' TYPE_RAIL" ).append("\n"); 
		query.append(",'' CRE_USR_ID" ).append("\n"); 
		query.append("FROM  BKG_BOOKING A" ).append("\n"); 
		query.append(",BKG_BL_DOC D" ).append("\n"); 
		query.append(",BKG_CONTAINER E" ).append("\n"); 
		query.append("WHERE  A.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND  A.BKG_NO = E.BKG_NO" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("AND  A.VSL_CD = SUBSTR(@[vvd], 1,4)" ).append("\n"); 
		query.append("AND  A.SKD_VOY_NO = SUBSTR(@[vvd], 5,4)" ).append("\n"); 
		query.append("AND  A.SKD_DIR_CD = SUBSTR(@[vvd], 9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bound} == 'I')" ).append("\n"); 
		query.append("AND  A.POD_CD = @[port]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND  A.POL_CD = @[port]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.BL_NO, E.CNTR_NO" ).append("\n"); 

	}
}