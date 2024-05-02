/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOBkgBlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.24 
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

public class BLDocumentationBLDBDAOBkgBlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * update
	  * </pre>
	  */
	public BLDocumentationBLDBDAOBkgBlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt_prn_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ttl_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_wgt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pck_cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("meas_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pck_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOBkgBlUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_DOC_HIS" ).append("\n"); 
		query.append("SET    TTL_PCK_DESC      = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[ttl_pck_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",      CSTMS_DESC        = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[cstms_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '),'[^ a-zA-Z0-9~!@#$%^&*()-_+={}|:;,<.>/`\"▤'']','', 1, 0, 'im'), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",      PCK_CMDT_DESC     = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[pck_cmdt_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",      CNTR_CMDT_DESC    = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[cntr_cmdt_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",      PCK_QTY           = @[pck_qty]" ).append("\n"); 
		query.append(",      PCK_TP_CD         = @[pck_tp_cd]" ).append("\n"); 
		query.append(",      MEAS_QTY          = @[meas_qty]" ).append("\n"); 
		query.append(",      MEAS_UT_CD        = @[meas_ut_cd]" ).append("\n"); 
		query.append(",      ACT_WGT           = @[act_wgt]" ).append("\n"); 
		query.append(",      WGT_UT_CD         = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",      ACT_WGT_PRN_FLG   = DECODE (@[act_wgt_prn_flg], 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",      CMDT_HS_CD         = @[cmdt_hs_cd]" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO='TMP0000001'" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE BKG_BL_DOC" ).append("\n"); 
		query.append("SET    TTL_PCK_DESC      = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[ttl_pck_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",      CSTMS_DESC        = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[cstms_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '),'[^ a-zA-Z0-9~!@#$%^&*()-_+={}|:;,<.>/`\"▤'']','', 1, 0, 'im'), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",      PCK_CMDT_DESC     = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[pck_cmdt_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",      CNTR_CMDT_DESC    = REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(REGEXP_REPLACE(@[cntr_cmdt_desc], chr(13)||chr(10), '▤') , chr(10),''), chr(13), '▤'), chr(9), ' '), '▤' ,chr(13)||chr(10))" ).append("\n"); 
		query.append(",      PCK_QTY           = @[pck_qty]" ).append("\n"); 
		query.append(",      PCK_TP_CD         = @[pck_tp_cd]" ).append("\n"); 
		query.append(",      MEAS_QTY          = @[meas_qty]" ).append("\n"); 
		query.append(",      MEAS_UT_CD        = @[meas_ut_cd]" ).append("\n"); 
		query.append(",      ACT_WGT           = @[act_wgt]" ).append("\n"); 
		query.append(",      WGT_UT_CD         = @[wgt_ut_cd]" ).append("\n"); 
		query.append(",      ACT_WGT_PRN_FLG   = DECODE (@[act_wgt_prn_flg], 'Y', 'Y', 'N')" ).append("\n"); 
		query.append(",      CMDT_HS_CD         = @[cmdt_hs_cd]" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}