/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAObkgmodifyBkgBookingAfterCombineUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAObkgmodifyBkgBookingAfterCombineUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * combine이후 term, status 를 정리한다.
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAObkgmodifyBkgBookingAfterCombineUSQL(){
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
		params.put("mst_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAObkgmodifyBkgBookingAfterCombineUSQL").append("\n"); 
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
		query.append("update bkg_booking" ).append("\n"); 
		query.append("set WT_RSN_SPCL_CGO_FLG =" ).append("\n"); 
		query.append("         nvl((select case when count(1) = 1 then 'Y' else null end " ).append("\n"); 
		query.append("              from bkg_booking " ).append("\n"); 
		query.append("               where bkg_no in (" ).append("\n"); 
		query.append("#foreach($bkgNo IN ${bkg_no})        " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_no.size()) '$bkgNo', #else '$bkgNo' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("               and WT_RSN_SPCL_CGO_FLG = 'Y'" ).append("\n"); 
		query.append("               and rownum = 1), 'N') " ).append("\n"); 
		query.append("  , WT_RSN_HLD_FLG =                " ).append("\n"); 
		query.append("         nvl((select case when count(1) = 1 then 'Y' else null end   " ).append("\n"); 
		query.append("                from bkg_booking" ).append("\n"); 
		query.append("               where bkg_no in (" ).append("\n"); 
		query.append("#foreach($bkgNo IN ${bkg_no})        " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_no.size()) '$bkgNo', #else '$bkgNo' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("                 and WT_RSN_HLD_FLG = 'Y'" ).append("\n"); 
		query.append("                 and rownum = 1), 'N') " ).append("\n"); 
		query.append("  , rcv_term_cd = decode((select case when count(1) = 1 then 'NORMAL'" ).append("\n"); 
		query.append("                                     else 'MIXED' end rcv_term_cd" ).append("\n"); 
		query.append("                           from (select distinct rcv_term_cd" ).append("\n"); 
		query.append("                                   from bkg_booking" ).append("\n"); 
		query.append("					              where bkg_no in (" ).append("\n"); 
		query.append("#foreach($bkgNo IN ${bkg_no})        " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_no.size()) '$bkgNo', #else '$bkgNo' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("								)))" ).append("\n"); 
		query.append("                         , 'MIXED', 'M', rcv_term_cd)" ).append("\n"); 
		query.append("  , de_term_Cd  = decode((select case when count(1) = 1 then 'NORMAL'" ).append("\n"); 
		query.append("                                     else 'MIXED' end de_term_cd" ).append("\n"); 
		query.append("                           from (select distinct de_term_cd" ).append("\n"); 
		query.append("                                   from bkg_booking" ).append("\n"); 
		query.append("					              where bkg_no in (" ).append("\n"); 
		query.append("#foreach($bkgNo IN ${bkg_no})        " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_no.size()) '$bkgNo', #else '$bkgNo' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("								)))" ).append("\n"); 
		query.append("                         , 'MIXED', 'M', de_term_cd)" ).append("\n"); 
		query.append("  , bkg_sts_cd =  " ).append("\n"); 
		query.append("         nvl((select case when count(1) = 1 then 'W' else null end  " ).append("\n"); 
		query.append("                from bkg_booking" ).append("\n"); 
		query.append("               where bkg_no in (" ).append("\n"); 
		query.append("#foreach($bkgNo IN ${bkg_no})        " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_no.size()) '$bkgNo', #else '$bkgNo' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("                 and bkg_sts_cd = 'W'    " ).append("\n"); 
		query.append("                 and rownum = 1), bkg_sts_cd)   " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  , FLEX_HGT_FLG =  " ).append("\n"); 
		query.append("         nvl((select case when count(1) = 1 then 'Y' else 'N' end  " ).append("\n"); 
		query.append("                from bkg_booking" ).append("\n"); 
		query.append("               where bkg_no in (" ).append("\n"); 
		query.append("#foreach($bkgNo IN ${bkg_no})        " ).append("\n"); 
		query.append("	#if($velocityCount < $bkg_no.size()) '$bkgNo', #else '$bkgNo' #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("                 and FLEX_HGT_FLG = 'Y'    " ).append("\n"); 
		query.append("                 and rownum = 1), FLEX_HGT_FLG)   " ).append("\n"); 
		query.append("  , upd_dt = sysdate" ).append("\n"); 
		query.append("  , upd_usr_id = @[usr_id]  " ).append("\n"); 
		query.append("  , LST_SAV_DT = SYSDATE                " ).append("\n"); 
		query.append("where bkg_no = @[mst_bkg_no]" ).append("\n"); 

	}
}