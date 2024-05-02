/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchDoNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.10.06 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mangeon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchDoNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * India 및 EU Cargo Release시 Split된 booking에 대한 최근 DO번호를 조회한다. 단 SPLIT인 경우만 유효한 값을 제공한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDoNoRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchDoNoRSQL").append("\n"); 
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
		query.append("SELECT DECODE(DO_NO_SPLIT, '00', NULL, DO_NO) DO_NO" ).append("\n"); 
		query.append("FROM (SELECT /*+ INDEX_DESC (BKG_DO XPKBKG_DO) */" ).append("\n"); 
		query.append("DO_NO" ).append("\n"); 
		query.append(", DO_NO_SPLIT" ).append("\n"); 
		query.append(", COUNT(1) CNT" ).append("\n"); 
		query.append("FROM BKG_DO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append("GROUP BY DO_NO, DO_NO_SPLIT" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}