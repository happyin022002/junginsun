/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceVVDCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceVVDCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MultiTerminalInvoiceVVD
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceVVDCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atb_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("userId",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("call_yd_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOMultiTerminalInvoiceVVDCSQL").append("\n"); 
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
		query.append("MERGE INTO TES_TML_SO_VVD_LIST V" ).append("\n"); 
		query.append("USING  DUAL" ).append("\n"); 
		query.append("ON ( V.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND V.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("    AND V.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("    AND V.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("    AND V.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("    AND V.IO_BND_CD = @[io_bnd_cd]		)" ).append("\n"); 
		query.append("WHEN MATCHED THEN" ).append("\n"); 
		query.append("    UPDATE" ).append("\n"); 
		query.append("    SET " ).append("\n"); 
		query.append("#if (${call_yd_ind_seq} != '' && ${call_yd_ind_seq} != 'undefined') " ).append("\n"); 
		query.append("			CALL_YD_IND_SEQ = @[call_yd_ind_seq],   " ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		UPD_USR_ID = @[userId],        " ).append("\n"); 
		query.append("		UPD_DT = SYSDATE" ).append("\n"); 
		query.append("WHEN NOT MATCHED THEN" ).append("\n"); 
		query.append("    INSERT (TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("            TML_SO_SEQ," ).append("\n"); 
		query.append("            TML_SO_VVD_LIST_SEQ," ).append("\n"); 
		query.append("            VSL_CD," ).append("\n"); 
		query.append("            SKD_VOY_NO," ).append("\n"); 
		query.append("            SKD_DIR_CD," ).append("\n"); 
		query.append("            IO_BND_CD," ).append("\n"); 
		query.append("            ATB_DT," ).append("\n"); 
		query.append("#if (${call_yd_ind_seq} != '' && ${call_yd_ind_seq} != 'undefined') " ).append("\n"); 
		query.append("			CALL_YD_IND_SEQ," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            CRE_USR_ID," ).append("\n"); 
		query.append("            CRE_DT," ).append("\n"); 
		query.append("			UPD_USR_ID," ).append("\n"); 
		query.append("			UPD_DT" ).append("\n"); 
		query.append("			)" ).append("\n"); 
		query.append("    VALUES (@[tml_so_ofc_cty_cd]," ).append("\n"); 
		query.append("            @[tml_so_seq], " ).append("\n"); 
		query.append("            (SELECT TO_NUMBER(NVL(MAX(TML_SO_VVD_LIST_SEQ),'0'))+1 FROM TES_TML_SO_VVD_LIST WHERE TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd] AND TML_SO_SEQ = @[tml_so_seq])," ).append("\n"); 
		query.append("            SUBSTR(@[vvd],1,4), " ).append("\n"); 
		query.append("            SUBSTR(@[vvd],5,4), " ).append("\n"); 
		query.append("            SUBSTR(@[vvd],9,1), " ).append("\n"); 
		query.append("            @[io_bnd_cd]," ).append("\n"); 
		query.append("            TO_DATE(REPLACE(@[atb_dt],'-',''),'YYYYMMDD'), " ).append("\n"); 
		query.append("#if (${call_yd_ind_seq} != '' && ${call_yd_ind_seq} != 'undefined')  " ).append("\n"); 
		query.append("			@[call_yd_ind_seq]," ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("            @[userId], " ).append("\n"); 
		query.append("            SYSDATE, " ).append("\n"); 
		query.append("            @[userId], " ).append("\n"); 
		query.append("            SYSDATE)" ).append("\n"); 

	}
}