/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BDRCorrectionDBDAOCheckMkAndCmdtDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.09.27 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOCheckMkAndCmdtDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * M&D Mark / Descripton 변경시 면제가능여부를 확인한다.
	  * </pre>
	  */
	public BDRCorrectionDBDAOCheckMkAndCmdtDescRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOCheckMkAndCmdtDescRSQL").append("\n"); 
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
		query.append("SELECT MKDESC.MK_DESC MK" ).append("\n"); 
		query.append("      , MKDESC_HIS.MK_DESC MK_HIS" ).append("\n"); 
		query.append("      , MKDESC.CMDT_DESC CMDT" ).append("\n"); 
		query.append("      , MKDESC_HIS.CMDT_DESC CMDT_HIS" ).append("\n"); 
		query.append("  FROM BKG_BL_MK_DESC     MKDESC" ).append("\n"); 
		query.append("      ,BKG_BL_MK_DESC_HIS MKDESC_HIS" ).append("\n"); 
		query.append(" WHERE MKDESC.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND MKDESC_HIS.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("   AND MKDESC.BKG_NO  = MKDESC_HIS.BKG_NO" ).append("\n"); 
		query.append("   AND MKDESC.MK_SEQ  = MKDESC_HIS.MK_SEQ" ).append("\n"); 

	}
}