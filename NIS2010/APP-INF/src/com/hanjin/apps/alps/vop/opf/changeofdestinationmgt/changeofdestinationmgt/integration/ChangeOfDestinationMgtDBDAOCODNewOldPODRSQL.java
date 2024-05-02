/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD의 NEW POD CD, OLD POD CD SELECT
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL(){
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
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOCODNewOldPODRSQL").append("\n"); 
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
		query.append("SELECT     SUBSTR(BC.OLD_POD_YD_CD,1,5)         AS OLD_POD_CD" ).append("\n"); 
		query.append(",   (SELECT   ML.LOC_NM" ).append("\n"); 
		query.append("FROM     MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE    ML.LOC_CD    = SUBSTR(BC.OLD_POD_YD_CD,1,5)" ).append("\n"); 
		query.append(")                                    AS OLD_POD_FULL_NM" ).append("\n"); 
		query.append(",   SUBSTR(BC.NEW_POD_YD_CD,1,5)         AS NEW_POD_CD" ).append("\n"); 
		query.append(",   (SELECT   ML.LOC_NM" ).append("\n"); 
		query.append("FROM     MDM_LOCATION ML" ).append("\n"); 
		query.append("WHERE    ML.LOC_CD    = SUBSTR(BC.NEW_POD_YD_CD,1,5)" ).append("\n"); 
		query.append(")                                    AS NEW_POD_FULL_NM" ).append("\n"); 
		query.append("FROM       BKG_COD             BC" ).append("\n"); 
		query.append("WHERE      BC.BKG_NO           = @[bkg_no]" ).append("\n"); 
		query.append("AND        BC.COD_RQST_SEQ     = @[cod_rqst_seq]" ).append("\n"); 

	}
}