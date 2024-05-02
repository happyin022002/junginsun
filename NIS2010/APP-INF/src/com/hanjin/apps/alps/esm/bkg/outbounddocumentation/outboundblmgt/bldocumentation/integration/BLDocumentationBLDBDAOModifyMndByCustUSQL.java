/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOModifyMndByCustUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.01
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2010.12.01 최도순
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Do Soon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOModifyMndByCustUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLDocumentationBLDBDAOModifyMndByCustUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("old_act_cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_act_cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOModifyMndByCustUSQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BL_MK_DESC_HIS" ).append("\n"); 
		query.append("SET    CMDT_DESC =  ( CASE WHEN " ).append("\n"); 
		query.append("                            DECODE(@[old_act_cust_cd],'','',(SELECT 'X' " ).append("\n"); 
		query.append("                             FROM BKG_BL_MK_DESC_HIS " ).append("\n"); 
		query.append("                             WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("                             AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("                             AND   CMDT_DESC LIKE '%'||@[old_act_cust_nm]||'%' )) IS NULL THEN (SELECT DECODE(@[new_act_cust_cd],NULL,''" ).append("\n"); 
		query.append("                                                                                                                      ,'exporter reference :'||@[new_act_cust_nm]||CHR(13))||CMDT_DESC " ).append("\n"); 
		query.append("                                                                                      FROM BKG_BL_MK_DESC_HIS " ).append("\n"); 
		query.append("                                                                                      WHERE BKG_NO= @[bkg_no] AND CORR_NO = 'TMP0000001')  " ).append("\n"); 
		query.append("                                                                                ELSE ( SELECT DECODE(@[new_act_cust_cd],NULL,REPLACE(CMDT_DESC,'exporter reference :'||@[old_act_cust_nm]" ).append("\n"); 
		query.append("                                                                                                                                              ,'')" ).append("\n"); 
		query.append("                                                                                                                       ,REPLACE(CMDT_DESC,@[old_act_cust_nm],@[new_act_cust_nm])                                                         " ).append("\n"); 
		query.append("                                                                                                     ) " ).append("\n"); 
		query.append("                                                                                       FROM BKG_BL_MK_DESC_HIS" ).append("\n"); 
		query.append("                                                                                       WHERE BKG_NO= @[bkg_no] AND CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("                          END)" ).append("\n"); 
		query.append(",      UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",      UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE  BKG_NO     =  @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BL_MK_DESC" ).append("\n"); 
		query.append("SET    CMDT_DESC =  ( CASE WHEN " ).append("\n"); 
		query.append("                            DECODE(@[old_act_cust_cd],'','',(SELECT 'X' " ).append("\n"); 
		query.append("                             FROM BKG_BL_MK_DESC " ).append("\n"); 
		query.append("                             WHERE BKG_NO= @[bkg_no]" ).append("\n"); 
		query.append("                             AND   MK_SEQ=1 " ).append("\n"); 
		query.append("                             AND   CMDT_DESC LIKE '%'||@[old_act_cust_nm]||'%' )) IS NULL THEN (SELECT DECODE(@[new_act_cust_cd],NULL,''" ).append("\n"); 
		query.append("                                                                                                                      ,'exporter reference :'||@[new_act_cust_nm]||CHR(13))||CMDT_DESC " ).append("\n"); 
		query.append("                                                                                      FROM BKG_BL_MK_DESC " ).append("\n"); 
		query.append("                                                                                      WHERE BKG_NO= @[bkg_no] AND MK_SEQ=1)  " ).append("\n"); 
		query.append("                                                                                ELSE ( SELECT DECODE(@[new_act_cust_cd],NULL,REPLACE(CMDT_DESC,'exporter reference :'||@[old_act_cust_nm]" ).append("\n"); 
		query.append("                                                                                                                                              ,'')" ).append("\n"); 
		query.append("                                                                                                                       ,REPLACE(CMDT_DESC,@[old_act_cust_nm],@[new_act_cust_nm])                                                         " ).append("\n"); 
		query.append("                                                                                                     ) " ).append("\n"); 
		query.append("                                                                                       FROM BKG_BL_MK_DESC " ).append("\n"); 
		query.append("                                                                                       WHERE BKG_NO= @[bkg_no] AND MK_SEQ=1)" ).append("\n"); 
		query.append("                          END)" ).append("\n"); 
		query.append(",      UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",      UPD_DT     = SYSDATE" ).append("\n"); 
		query.append("WHERE  BKG_NO     =  @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}