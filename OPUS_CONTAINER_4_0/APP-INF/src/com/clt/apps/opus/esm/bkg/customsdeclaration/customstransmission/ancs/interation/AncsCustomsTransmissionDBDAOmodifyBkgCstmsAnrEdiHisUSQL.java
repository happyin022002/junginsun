/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AncsCustomsTransmissionDBDAOmodifyBkgCstmsAnrEdiHisUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.07.13 정재엽
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong Jae Yoeb
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AncsCustomsTransmissionDBDAOmodifyBkgCstmsAnrEdiHisUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * UP
	  * </pre>
	  */
	public AncsCustomsTransmissionDBDAOmodifyBkgCstmsAnrEdiHisUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anr_edi_rtn_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ref_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("anr_decl_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("edi_msg_err_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("err_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation").append("\n"); 
		query.append("FileName : AncsCustomsTransmissionDBDAOmodifyBkgCstmsAnrEdiHisUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ANR_EDI_HIS" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("EDI_RCV_STS_CD  = @[edi_rcv_sts_cd]--'A'" ).append("\n"); 
		query.append(",RCV_DT         = SYSDATE" ).append("\n"); 
		query.append(",ANR_EDI_RTN_ID = @[anr_edi_rtn_id]--'44'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",MSG_LOC_CD     = @[msg_loc_cd] --NULL" ).append("\n"); 
		query.append(",EDI_MSG_ERR_ID = @[edi_msg_err_id] --NULL" ).append("\n"); 
		query.append(",ERR_DESC       = @[err_desc] --NULL" ).append("\n"); 
		query.append(",ERR_CTNT       = @[err_ctnt] --NULL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",UPD_USR_ID     = @[upd_usr_id] --'007'" ).append("\n"); 
		query.append(",UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND MSG_TP_CD   = @[msg_tp_cd]   --'R'" ).append("\n"); 
		query.append("AND ANR_DECL_NO = @[anr_decl_no] --'302543L9149744'" ).append("\n"); 
		query.append("AND REF_SEQ     = @[ref_seq]     --'000003'" ).append("\n"); 

	}
}