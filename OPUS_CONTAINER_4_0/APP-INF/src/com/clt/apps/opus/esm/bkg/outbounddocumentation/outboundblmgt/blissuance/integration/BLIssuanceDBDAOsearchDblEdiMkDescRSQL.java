/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchDblEdiMkDescRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.05 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchDblEdiMkDescRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchDblEdiMkDescRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_receive_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchDblEdiMkDescRSQL").append("\n"); 
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
		query.append("SELECT 'BL_DESC:' || REPLACE(REPLACE(CMDT_DESC, CHR(13),''), CHR(10), CHR(10)||'BL_DESC:') || CHR(10)" ).append("\n"); 
		query.append(",'MARKNO:' || REPLACE(REPLACE(MK_DESC, CHR(13),''), CHR(10), CHR(10)||'MARKNO:') || CHR(10)" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' THEN" ).append("\n"); 
		query.append("REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(CMDT_DESC, '&', CHR(38)||'amp'||CHR(59)), '<', CHR(38)||'lt'||CHR(59)), '>', CHR(38)||'gt'||CHR(59)), '\"', CHR(38)||'quot'||CHR(59)), CHR(39), CHR(38)||'apos'||CHR(59))" ).append("\n"); 
		query.append("WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("CMDT_DESC" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("REPLACE(REPLACE(REPLACE(CMDT_DESC, '*', '-'), ':', '-'), '~', '-')" ).append("\n"); 
		query.append("END CMDT_DESC" ).append("\n"); 
		query.append(",      CASE" ).append("\n"); 
		query.append("WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'SDIXML' THEN" ).append("\n"); 
		query.append("REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(MK_DESC, '&', CHR(38)||'amp'||CHR(59)), '<', CHR(38)||'lt'||CHR(59)), '>', CHR(38)||'gt'||CHR(59)), '\"', CHR(38)||'quot'||CHR(59)), CHR(39), CHR(38)||'apos'||CHR(59))" ).append("\n"); 
		query.append("WHEN SUBSTR(@[edi_receive_id], 1, 6) = 'LEHXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'PKEXML' OR" ).append("\n"); 
		query.append("SUBSTR(@[edi_receive_id], 1, 6) = 'PKCXML' OR SUBSTR(@[edi_receive_id], 1, 6) = 'LGEXML' OR" ).append("\n"); 
		query.append("SUBSTR(@[edi_receive_id], 1, 8) = 'CNLGEXML' OR SUBSTR(@[edi_receive_id], 1, 5) = 'EIXML' OR" ).append("\n"); 
		query.append("SUBSTR(@[edi_receive_id], 1, 6) = 'EIXMLC' THEN" ).append("\n"); 
		query.append("MK_DESC" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("REPLACE(REPLACE(REPLACE(MK_DESC, '*', '-'), ':', '-'), '~', '-')" ).append("\n"); 
		query.append("END MK_DESC" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DECODE(A1.PCK_CMDT_DESC,'',''," ).append("\n"); 
		query.append("CASE WHEN INSTR(A1.PCK_CMDT_DESC, ' ', 1) < 8 AND INSTR(A1.PCK_CMDT_DESC, ' ', 1) > 0 THEN" ).append("\n"); 
		query.append("RPAD(' ',8 - INSTR(A1.PCK_CMDT_DESC, ' ', 1), ' ')" ).append("\n"); 
		query.append("END || A1.PCK_CMDT_DESC || CHR(10))" ).append("\n"); 
		query.append("|| DECODE(A1.CNTR_CMDT_DESC,'',''," ).append("\n"); 
		query.append("CASE WHEN INSTR(A1.CNTR_CMDT_DESC, ' ', 1) < 8 AND INSTR(A1.CNTR_CMDT_DESC, ' ', 1) > 0 THEN" ).append("\n"); 
		query.append("RPAD(' ',8 - INSTR(A1.CNTR_CMDT_DESC, ' ', 1), ' ')" ).append("\n"); 
		query.append("END || A1.CNTR_CMDT_DESC || CHR(10))" ).append("\n"); 
		query.append("|| A2.CMDT_DESC AS CMDT_DESC" ).append("\n"); 
		query.append(",A2.MK_DESC" ).append("\n"); 
		query.append("FROM   BKG_BL_DOC A1" ).append("\n"); 
		query.append(",BKG_BL_MK_DESC A2" ).append("\n"); 
		query.append("WHERE  A1.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    A1.BKG_NO = A2.BKG_NO" ).append("\n"); 
		query.append("AND    A2.MK_SEQ = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}