/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLDocumentationBLDBDAOcopyHblByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.12 
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

public class BLDocumentationBLDBDAOcopyHblByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationBLDBDAOcopyHblByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("targetBkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOcopyHblByBkgCSQL").append("\n"); 
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
		query.append("insert into bkg_hbl" ).append("\n"); 
		query.append("(BKG_NO" ).append("\n"); 
		query.append(", HBL_SEQ" ).append("\n"); 
		query.append(", HBL_NO" ).append("\n"); 
		query.append(", CNTR_MF_NO" ).append("\n"); 
		query.append(", ORG_CNTR_MF_NO" ).append("\n"); 
		query.append(", BL_MK_DESC" ).append("\n"); 
		query.append(", BL_GDS_DESC" ).append("\n"); 
		query.append(", HBL_WGT" ).append("\n"); 
		query.append(", WGT_UT_CD" ).append("\n"); 
		query.append(", PCK_QTY" ).append("\n"); 
		query.append(", PCK_TP_CD" ).append("\n"); 
		query.append(", CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append(", CMDT_MEAS_QTY" ).append("\n"); 
		query.append(", XTER_SI_NO" ).append("\n"); 
		query.append(", XTER_SI_SEQ" ).append("\n"); 
		query.append(", DO_NO" ).append("\n"); 
		query.append(", DO_NO_SPLIT" ).append("\n"); 
		query.append(", IDA_IEC_NO" ).append("\n"); 
		query.append(", HBL_MF_TP_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT)" ).append("\n"); 
		query.append("select @[targetBkg] BKG_NO" ).append("\n"); 
		query.append(", hbl.HBL_SEQ + (SELECT NVL(MAX(hbl_seq), 0)" ).append("\n"); 
		query.append("FROM bkg_hbl" ).append("\n"); 
		query.append("WHERE bkg_no = @[targetBkg])" ).append("\n"); 
		query.append(", hbl.HBL_NO" ).append("\n"); 
		query.append("#if(${copy_mode_cd} == 'S')" ).append("\n"); 
		query.append(", null CNTR_MF_NO" ).append("\n"); 
		query.append(", hbl.CNTR_MF_NO ORG_CNTR_MF_NO" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append(", hbl.CNTR_MF_NO" ).append("\n"); 
		query.append(", hbl.ORG_CNTR_MF_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(", hbl.BL_MK_DESC" ).append("\n"); 
		query.append(", hbl.BL_GDS_DESC" ).append("\n"); 
		query.append(", hbl.HBL_WGT" ).append("\n"); 
		query.append(", hbl.WGT_UT_CD" ).append("\n"); 
		query.append(", hbl.PCK_QTY" ).append("\n"); 
		query.append(", hbl.PCK_TP_CD" ).append("\n"); 
		query.append(", hbl.CMDT_MEAS_UT_CD" ).append("\n"); 
		query.append(", hbl.CMDT_MEAS_QTY" ).append("\n"); 
		query.append(", hbl.XTER_SI_NO" ).append("\n"); 
		query.append(", hbl.XTER_SI_SEQ" ).append("\n"); 
		query.append(", hbl.DO_NO" ).append("\n"); 
		query.append(", hbl.DO_NO_SPLIT" ).append("\n"); 
		query.append(", hbl.IDA_IEC_NO" ).append("\n"); 
		query.append(", hbl.HBL_MF_TP_CD" ).append("\n"); 
		query.append(", @[usr_id] CRE_USR_ID" ).append("\n"); 
		query.append(", sysdate CRE_DT" ).append("\n"); 
		query.append(", @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append(", sysdate UPD_DT" ).append("\n"); 
		query.append("from bkg_hbl hbl" ).append("\n"); 
		query.append("where hbl.bkg_no = @[bkg_no]" ).append("\n"); 

	}
}