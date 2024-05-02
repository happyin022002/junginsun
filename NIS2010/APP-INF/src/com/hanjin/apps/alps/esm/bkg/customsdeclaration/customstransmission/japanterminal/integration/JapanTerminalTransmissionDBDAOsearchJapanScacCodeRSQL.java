/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOsearchJapanScacCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 조원주
*@LastVersion : 1.0
* 2012.03.20 조원주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHO WON-JOO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOsearchJapanScacCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * flat file 형성을 위한 타선사의 Japan Scac code 조회 쿼리
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOsearchJapanScacCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration ").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOsearchJapanScacCodeRSQL").append("\n"); 
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
		query.append("SELECT M.CRR_CD, B.BKG_NO, B.SCAC_CD" ).append("\n"); 
		query.append("FROM BKG_BOOKING B, BKG_VVD V, MDM_VSL_CNTR M " ).append("\n"); 
		query.append(" WHERE B.BKG_NO=V.BKG_NO" ).append("\n"); 
		query.append("AND B.POL_CD LIKE 'JP%'" ).append("\n"); 
		query.append("AND B.BKG_CRE_DT > SYSDATE - 100" ).append("\n"); 
		query.append("AND V.VSL_CD=M.VSL_CD" ).append("\n"); 

	}
}