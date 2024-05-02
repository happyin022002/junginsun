/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOCreatePartnerEDISpclCgoSeqMapgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOCreatePartnerEDISpclCgoSeqMapgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI DG Item SEQ와 Container SEQ와의 매핑정보를 저정한다.
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOCreatePartnerEDISpclCgoSeqMapgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_itm_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_spcl_cgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_mapg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOCreatePartnerEDISpclCgoSeqMapgCSQL").append("\n"); 
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
		query.append("INSERT INTO 	SCG_PRNR_SPCL_CGO_SEQ_MAPG" ).append("\n"); 
		query.append("				(" ).append("\n"); 
		query.append("					PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("				,	CGO_MAPG_SEQ" ).append("\n"); 
		query.append("				,	CNTR_SEQ" ).append("\n"); 
		query.append("				,	CGO_SEQ" ).append("\n"); 
		query.append("				,	CNTR_TPSZ_CD" ).append("\n"); 
		query.append("				,	CNTR_REF_NO" ).append("\n"); 
		query.append("				,	EDI_ITM_SEQ" ).append("\n"); 
		query.append("				,	DCGO_REF_NO" ).append("\n"); 
		query.append("				,	CRE_USR_ID" ).append("\n"); 
		query.append("				,	CRE_DT" ).append("\n"); 
		query.append("				,	UPD_USR_ID" ).append("\n"); 
		query.append("				,	UPD_DT" ).append("\n"); 
		query.append("				)" ).append("\n"); 
		query.append("VALUES			(" ).append("\n"); 
		query.append("					@[prnr_spcl_cgo_seq]			/* PRNR_SPCL_CGO_SEQ    */" ).append("\n"); 
		query.append("				,	@[cgo_mapg_seq]					/* CGO_MAPG_SEQ         */" ).append("\n"); 
		query.append("				,	@[cntr_seq]         			/* CNTR_SEQ             */" ).append("\n"); 
		query.append("				,	@[cgo_seq]          			/* CGO_SEQ              */" ).append("\n"); 
		query.append("				,	@[cntr_tpsz_cd]     			/* CNTR_TPSZ_CD         */" ).append("\n"); 
		query.append("				,	@[cntr_ref_no]      			/* CNTR_REF_NO          */" ).append("\n"); 
		query.append("				,	@[edi_itm_seq]      			/* EDI_ITM_SEQ          */" ).append("\n"); 
		query.append("				,	@[dcgo_ref_no]      			/* DCGO_REF_NO          */" ).append("\n"); 
		query.append("				,	'EDI'       					/* CRE_USR_ID           */" ).append("\n"); 
		query.append("				,	SYSDATE      					/* CRE_DT               */" ).append("\n"); 
		query.append("				,	'EDI'       					/* UPD_USR_ID           */" ).append("\n"); 
		query.append("				,	SYSDATE           				/* UPD_DT				*/" ).append("\n"); 
		query.append("				)" ).append("\n"); 

	}
}