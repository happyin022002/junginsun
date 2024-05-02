/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPforReverifyCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2009.10.05 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPforReverifyCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateTES_FILE_IMP_TMPforReverify
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPforReverifyCSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOCreateTES_FILE_IMP_TMPforReverifyCSQL").append("\n"); 
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
		query.append("INSERT INTO TES_FILE_IMP_TMP(" ).append("\n"); 
		query.append("TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("TML_SO_SEQ," ).append("\n"); 
		query.append("TML_SO_TMP_SEQ," ).append("\n"); 
		query.append("CNTR_NO," ).append("\n"); 
		query.append("CNTR_TPSZ_CD," ).append("\n"); 
		query.append("CNTR_STY_CD," ).append("\n"); 
		query.append("IO_BND_CD," ).append("\n"); 
		query.append("VNDR_SEQ," ).append("\n"); 
		query.append("YD_CD," ).append("\n"); 
		query.append("VVD_CD," ).append("\n"); 
		query.append("ATB_DT," ).append("\n"); 
		query.append("RCV_DT," ).append("\n"); 
		query.append("WRK_DT," ).append("\n"); 
		query.append("CRE_USR_ID," ).append("\n"); 
		query.append("CRE_DT," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT      H.TML_SO_OFC_CTY_CD," ).append("\n"); 
		query.append("H.TML_SO_SEQ," ).append("\n"); 
		query.append("ROWNUM," ).append("\n"); 
		query.append("C.CNTR_NO," ).append("\n"); 
		query.append("C.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("C.CNTR_STY_CD," ).append("\n"); 
		query.append("UPPER(C.IO_BND_CD)," ).append("\n"); 
		query.append("H.VNDR_SEQ," ).append("\n"); 
		query.append("H.YD_CD," ).append("\n"); 
		query.append("C.VSL_CD||C.SKD_VOY_NO||C.SKD_DIR_CD," ).append("\n"); 
		query.append("C.ATB_DT," ).append("\n"); 
		query.append("H.RCV_DT," ).append("\n"); 
		query.append("TO_CHAR(C.WRK_DT,'YYYYMMDD')," ).append("\n"); 
		query.append("@[cre_usr_id]," ).append("\n"); 
		query.append("SYSDATE," ).append("\n"); 
		query.append("@[upd_usr_id]," ).append("\n"); 
		query.append("SYSDATE" ).append("\n"); 
		query.append("FROM  TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST C" ).append("\n"); 
		query.append("WHERE H.TML_SO_OFC_CTY_CD = C.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = C.TML_SO_SEQ" ).append("\n"); 
		query.append("AND H.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("AND H.TML_SO_SEQ = @[tml_so_seq]" ).append("\n"); 
		query.append("AND C.VSL_CD = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND C.SKD_VOY_NO = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND C.SKD_DIR_CD = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND UPPER(C.IO_BND_CD) = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND C.VRFY_RSLT_IND_CD = 'DC'  --2008-07-30: 이D요청으로 대상을 Discrepancy만으로 ..." ).append("\n"); 

	}
}