/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOSearchDoStsRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.07.09 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim JinYoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOSearchDoStsRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 현 시점의 Current한 D/O Status 정보를 조회한다. 해당 부킹에 Max (RLSE_STS_SEQ)인 Status정보를 조회한다.
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOSearchDoStsRSQL(){
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
		params.put("rlse_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOSearchDoStsRSQL").append("\n"); 
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
		query.append("SELECT RLSE_STS_CD" ).append("\n"); 
		query.append("FROM BKG_DO_DTL" ).append("\n"); 
		query.append("WHERE BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("AND RLSE_SEQ = @[rlse_seq]" ).append("\n"); 
		query.append("AND RLSE_STS_SEQ = ( SELECT MAX( RLSE_STS_SEQ)" ).append("\n"); 
		query.append("FROM BKG_DO_DTL" ).append("\n"); 
		query.append("WHERE BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND RLSE_SEQ    = @[rlse_seq]" ).append("\n"); 
		query.append("AND RLSE_STS_CD <> 'C' )" ).append("\n"); 

	}
}