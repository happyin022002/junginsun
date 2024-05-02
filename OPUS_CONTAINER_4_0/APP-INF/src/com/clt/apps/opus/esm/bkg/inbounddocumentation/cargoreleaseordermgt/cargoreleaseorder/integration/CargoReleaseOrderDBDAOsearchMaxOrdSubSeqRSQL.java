/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOsearchMaxOrdSubSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.08 
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

public class CargoReleaseOrderDBDAOsearchMaxOrdSubSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_FULL_CGO_RLSE_ORD 테이블의 RLSE_ORD_SEQ의 MAX 값을 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOsearchMaxOrdSubSeqRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOsearchMaxOrdSubSeqRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(RLSE_ORD_SEQ), 0) AS RLSE_ORD_SEQ" ).append("\n"); 
		query.append("  FROM BKG_FULL_CGO_RLSE_ORD " ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("   AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}