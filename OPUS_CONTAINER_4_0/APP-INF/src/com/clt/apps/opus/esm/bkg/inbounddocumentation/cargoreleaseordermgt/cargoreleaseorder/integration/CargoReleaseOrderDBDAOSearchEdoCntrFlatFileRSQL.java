/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchEdoCntrFlatFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchEdoCntrFlatFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDO 요청으로접수된 CONTAINER 정보를 조회한다.
	  * 
	  * //AS-IS
	  * SELECT CNTR_NO,                                -- CNTR_NO
	  *        CNTR_TPSZ_CD                              -- CNTRTS_CD
	  * FROM BKG_EDO_CNTR
	  * WHERE EDO_RQST_NO  = :rqst_no
	  *   AND EDO_RQST_SEQ = ( SELECT NVL(MAX(EDO_RQST_SEQ), 1)
	  *                                           FROM BKG_EDO_MST
	  *                                         WHERE EDO_RQST_NO = :rqst_no
	  *                                             AND EDO_TP_CD   ='5JK' )
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchEdoCntrFlatFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchEdoCntrFlatFileRSQL").append("\n"); 
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
		query.append("SELECT 'CNTR_NO:'      || CNTR_NO ||'\\n'" ).append("\n"); 
		query.append("|| 'CNTR_TPSZ_CD:' || CNTR_TPSZ_CD ||'\\n' AS CONTAINER" ).append("\n"); 
		query.append("FROM BKG_EDO_CNTR  A" ).append("\n"); 
		query.append(", BKG_EDO_MST   B" ).append("\n"); 
		query.append("WHERE A.EDO_RQST_NO  = B.EDO_RQST_NO" ).append("\n"); 
		query.append("AND A.EDO_RQST_SEQ = B.EDO_RQST_SEQ" ).append("\n"); 
		query.append("AND A.EDO_RQST_NO  = @[rqst_no]" ).append("\n"); 
		query.append("AND B.VTY_FLG      = 'Y'" ).append("\n"); 
		query.append("AND B.EDO_TP_CD    = @[edo_tp_cd]" ).append("\n"); 

	}
}