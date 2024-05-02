/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PanamaCustomsTransmissionDBDAOsearchAttrCtntRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PanamaCustomsTransmissionDBDAOsearchAttrCtntRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchAttrCtnt
	  * </pre>
	  */
	public PanamaCustomsTransmissionDBDAOsearchAttrCtntRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hamotrpcd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("ATTR_CTNT2" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_CSTMS_CD_CONV_CTNT" ).append("\n"); 
		query.append("WHERE CNT_CD = 'PA'" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = 'PANAMA_MCT_CD'" ).append("\n"); 
		query.append("AND ATTR_CTNT1 = @[hamotrpcd]" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration ").append("\n"); 
		query.append("FileName : PanamaCustomsTransmissionDBDAOsearchAttrCtntRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}