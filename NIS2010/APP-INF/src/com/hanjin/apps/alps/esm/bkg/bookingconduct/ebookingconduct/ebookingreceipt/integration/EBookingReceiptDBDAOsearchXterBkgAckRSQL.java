/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EBookingReceiptDBDAOsearchXterBkgAckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.05 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOsearchXterBkgAckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchXterBkgAck
	  * </pre>
	  */
	public EBookingReceiptDBDAOsearchXterBkgAckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doc_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOsearchXterBkgAckRSQL").append("\n"); 
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
		query.append("SELECT	'$$$MSGSTART:'||RPAD(LTRIM(edi.SND_ID),20)||" ).append("\n"); 
		query.append("RPAD(LTRIM(DECODE(mst.xter_sndr_id, 'CRSEDI_UNOA', 'CRSEDI', 'CRSEDI_UNOB', 'CRSEDI', mst.xter_sndr_id)),20)||RPAD('APERAK',10)||" ).append("\n"); 
		query.append("RPAD(NVL(TRIM('BKG'),' '),3)||TO_CHAR(SYSDATE,'rrmmdd')||LTRIM(TO_CHAR(BKG_EDI_SEQ.nextval,'000009'),' ')||CHR(10)||" ).append("\n"); 
		query.append("'IB_CUST_RFF_NO:'   ||xter_instr.DOC_usr_ID             ||CHR(10)||" ).append("\n"); 
		query.append("'IB_SI_NO:'         ||mst.xter_rqst_no                  ||CHR(10)||" ).append("\n"); 
		query.append("'IB_EDI_ID:'        ||mst.xter_sndr_id                  ||CHR(10)||" ).append("\n"); 
		query.append("'IB_HJS_ID:'        ||edi.SND_ID                        ||CHR(10)||" ).append("\n"); 
		query.append("'IB_MSG_FLAG:'      ||@[doc_tp_cd]                      ||CHR(10)||" ).append("\n"); 
		query.append("'IB_PRC:'           ||'AP'                              ||CHR(10)||" ).append("\n"); 
		query.append("'IB_ERC:'           ||'OK'                              ||CHR(10)||" ).append("\n"); 
		query.append("'IB_FTX:'           ||'PROCESSING SUCCESSED'            ||CHR(10)||" ).append("\n"); 
		query.append("'IB_CUST_RFF_NO2:'  ||NVL(mst.CUST_ReF_NO, ' ')         ||CHR(10)||" ).append("\n"); 
		query.append("'IB_MBL_NO:'        ||BK.BL_NO||BK.BL_TP_CD             ||CHR(10)||" ).append("\n"); 
		query.append("'IB_BKG_NO:'        ||bk.bkg_no                         ||CHR(10)||" ).append("\n"); 
		query.append("'IB_VSL_NAME:'      ||VSL.VSL_ENG_NM                    ||CHR(10)||" ).append("\n"); 
		query.append("'IB_VOYAGE_NO:'     ||BK.SKD_VOY_NO                     ||CHR(10)||" ).append("\n"); 
		query.append("'IB_VSL_ETL: '      ||to_char(vps.VPS_ETB_DT,'YYYYMMDD')||CHR(10) FLAT_FILE" ).append("\n"); 
		query.append("FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append(", bkg_xter_instr xter_instr" ).append("\n"); 
		query.append(", bkg_BOOKING BK" ).append("\n"); 
		query.append(", mdm_VSL_cntr vsl" ).append("\n"); 
		query.append(", vsk_VSL_PORT_SKD vps" ).append("\n"); 
		query.append(", BKG_VVD vvd" ).append("\n"); 
		query.append(", (select grp.cust_trd_prnr_id rcv_id" ).append("\n"); 
		query.append(", grp.prov_trd_prnr_id SND_ID" ).append("\n"); 
		query.append("from edi_group grp" ).append("\n"); 
		query.append("where grp.delt_flg          = 'N'" ).append("\n"); 
		query.append("group by grp.cust_trd_prnr_id, grp.prov_trd_prnr_id ) edi" ).append("\n"); 
		query.append("where 1 = 1" ).append("\n"); 
		query.append("and mst.xter_sndr_id     = @[sender_id]" ).append("\n"); 
		query.append("and mst.xter_rqst_no     = @[rqst_no]" ).append("\n"); 
		query.append("and mst.xter_rqst_seq    = @[rqst_seq]" ).append("\n"); 
		query.append("AND mst.xter_rqst_no     = xter_instr.xter_rqst_no(+)" ).append("\n"); 
		query.append("AND mst.xter_rqst_seq    = xter_instr.xter_rqst_seq(+)" ).append("\n"); 
		query.append("AND mst.xter_sndr_id	    = xter_instr.xter_sndr_id(+)" ).append("\n"); 
		query.append("AND mst.xter_sndr_id     = edi.rcv_id" ).append("\n"); 
		query.append("AND mst.bkg_no           = BK.BKG_NO" ).append("\n"); 
		query.append("AND BK.VSL_CD            = VSL.VSL_CD" ).append("\n"); 
		query.append("AND bk.VSL_CD 			= vvd.VSL_CD" ).append("\n"); 
		query.append("AND bk.SKD_VOY_NO 	    = vvd.SKD_VOY_NO" ).append("\n"); 
		query.append("AND bk.SKD_DIR_CD 		= vvd.SKD_DIR_CD" ).append("\n"); 
		query.append("AND vvd.VSL_CD 			= vps.VSL_CD       (+)" ).append("\n"); 
		query.append("AND vvd.SKD_VOy_NO 	    = vps.SKD_VOY_NO   (+)" ).append("\n"); 
		query.append("AND vvd.SKD_DIR_CD 		= vps.SKD_DIR_CD   (+)" ).append("\n"); 
		query.append("and vvd.pol_clpt_ind_seq = vps.clpt_ind_seq (+)" ).append("\n"); 
		query.append("AND vvd.POL_cd 		    = vps.VPS_port_CD  (+)" ).append("\n"); 
		query.append("AND ROWNUM 		        = 1" ).append("\n"); 

	}
}