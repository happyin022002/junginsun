/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLDocumentationCMDBDAOChangeCntrSealNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOChangeCntrSealNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Seal No 에 대한 Key 변경 작업
	  * </pre>
	  */
	public BLDocumentationCMDBDAOChangeCntrSealNoUSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no_old",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOChangeCntrSealNoUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("UPDATE BKG_CNTR_SEAL_NO_HIS" ).append("\n"); 
		query.append("SET    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no_old]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE BKG_CNTR_SEAL_NO " ).append("\n"); 
		query.append("SET    CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CNTR_NO = @[cntr_no_old]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}