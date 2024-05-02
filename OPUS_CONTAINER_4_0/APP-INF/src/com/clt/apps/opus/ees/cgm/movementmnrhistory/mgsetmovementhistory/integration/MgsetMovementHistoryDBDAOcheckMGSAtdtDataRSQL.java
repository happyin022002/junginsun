/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MgsetMovementHistoryDBDAOcheckMGSAtdtDataRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MgsetMovementHistoryDBDAOcheckMGSAtdtDataRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public MgsetMovementHistoryDBDAOcheckMGSAtdtDataRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.clt.apps.opus.ees.cgm.movementmnrhistory.mgsetmovementhistory.integration").append("\n"); 
		query.append("FileName : MgsetMovementHistoryDBDAOcheckMGSAtdtDataRSQL").append("\n"); 
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
		query.append("SELECT  to_char( AA.ATCH_DT ,'yyyymmddHH24MIss') AS atch_dt" ).append("\n"); 
		query.append("      , AA.DTCH_YD_CD AS dtch_yd_cd" ).append("\n"); 
		query.append("      , AA.EQ_NO      AS eq_no" ).append("\n"); 
		query.append(" FROM" ).append("\n"); 
		query.append("	(" ).append("\n"); 
		query.append("	SELECT  " ).append("\n"); 
		query.append("		  A.ATCH_DT " ).append("\n"); 
		query.append("		, A.DTCH_YD_CD " ).append("\n"); 
		query.append("        , A.EQ_NO" ).append("\n"); 
		query.append("	FROM CGM_EQ_ATCH_DTCH_HIS A" ).append("\n"); 
		query.append("	WHERE 1=1 " ).append("\n"); 
		query.append("#if(${eq_tpsz_cd} == 'UMG')" ).append("\n"); 
		query.append("     AND  A.CHSS_NO = @[chss_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     AND  A.CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("     AND  A.EQ_KND_CD = 'G'" ).append("\n"); 
		query.append("	ORDER BY A.ATCH_DT DESC" ).append("\n"); 
		query.append("	) AA" ).append("\n"); 
		query.append("WHERE ROWNUM =1" ).append("\n"); 

	}
}